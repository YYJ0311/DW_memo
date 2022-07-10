# 1. 기본
    어떤 ip가 접속을 했는지를 controller 적어서 어떤 지역에서 들어왔는지 통계를 낼 수 있다.
```java
public class ActorController {
	@Autowired
	private MainService service;
	@GetMapping("/actor/list")
	public List<UserVO> callUserList(HttpServletRequest request){
		String ip = request.getHeader("X-forwarded-For");
		if(ip == null) ip = request.getRemoteAddr();
		System.out.println("IP ===>"+ip); // 위 주소에 접속시 이클립스에 "IP ===> ~ " 출력됨
		return service.getUserList();
	}
```
    request.getHeader("X-forwarded-For")를 사용하는 이유
        http 안에 header와 body가 들어있고, header에는 ip주소가 들어있다.
        X-forwarded-For (i.e. XFF) 는 HTTP 헤더 중 하나로, 원래의 IP 주소를 식별하기 위한 표준 헤더이다.

    header에 ip가 없는 경우(null) request.getRemoteAddr() 로 불러온다.


# 2. 응용 (모든 주소에 IP 조회 기능 붙이기)
    1번처럼 ip를 조회하려면 모든 메소드와 클래스에 기능을 추가해야 되므로 지저분해진다.
    따라서 요청이 Controller에 닿기 전에 가로채서 ip를 출력하게 만든다.
        (사용자가 요청을 서버에 보낼 때 마다 중간에 요청을 가로챌 수 있음(인터셉터) - 스프링 자체지원)

    2-1. interceptor 패키지와 클래스 생성
        ex) com.dw.board.interceptor / interceptor.java
    2-2. HandlerInterceptor 상속받고 해당 클래스가 갖는 메소드의 override 전부 생성
    2-3. conf 패키지에 설정파일 만들고 등록함
        ex) com.dw.board.conf 패키지 아래에 WebConfig 클래스 생성,
        WebConfig는 WebMvConfigure을 상속받고 addInterceptors를 override한 뒤 우리가 만든 인터셉터를 등록함
```java
package com.dw.board.interceptor;
import 생략
@Component 
public class Interceptor implements HandlerInterceptor{
	@Autowired
	LogsService logsService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//	preHandle : 컨트롤러에 도착하기 전에 가로채는 함수
			throws Exception {
		String url = request.getRequestURI();
		String ip = request.getHeader("X-forwarded-For");
		String httpMethod = request.getMethod();
		if(ip == null) ip = request.getRemoteAddr();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA); // 한국 시간으로 강제로 맞춤
		String time = formatter.format(Calendar.getInstance().getTime());
		LogsVO vo = new LogsVO(); // VO는 bean 등록을 안 하기 때문에 new로 부름
		vo.setUrl(url);
		vo.setIp(ip);
		vo.setHttpMethod(httpMethod);
		vo.setLatitude("36.3286904"); // 수업때 임의로 넣었는데 public ip로 위도, 경도를 변환해서 위치를 갖고 올 수 있다.
		vo.setLongitude("127.4229992");
		vo.setCreateAt(time);
		logsService.setLogs(vo); // ip를 포함한 정보를 담은 vo를 서비스로 넘겨서 이력을 남기고 관리할 것임
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
```
```java
package com.dw.board.conf;
import 생략
@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	private Interceptor interceptor; // 빈으로 등록한(Component 사용) 인터셉터 연결
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 우리가 만든 interceptor를 스프링에 등록
		registry.addInterceptor(interceptor)
	}
}
```

# 3. 특정 주소는 가로채는 것 제한하기
    주소로 요청이 들어올 때마다 로그가 쌓인다. 
    이 로그가 무분별하게 쌓이는 걸 막기 위해서 특정 주소로 요청받았을 때는 로그가 남지 않도록 한다.

    conf 파일에서 인터셉터를 등록했던 코드에 메소드체이닝을 이용해서 제외시킬 수 있음
```java
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).excludePathPatterns("/api/v1/logs"); 
		// /api/v1/logs경로는 interceptor에서 제외시킴
	}
```

# 4. 특정 주소에 조건으로 제한하기
	권한별 페이지 접근을 다르게 하고 싶은 경우 특정 주소에 조건을 걸어야 할 필요가 있다.
	excludeUrl.contains("주소") 를 이용하면 괄호 안의 주소를 조건으로 접속 여부를 결정할 수 있다.
```java
if(session.getAttribute("memberName") != null) {
	if(excludeUrl.contains("/health/login") || excludeUrl.contains("/health/join")) {
		response.sendRedirect("/health/index");
		return false; // 주소가 login, join 이라면 접근 불가능
	}
	if((int)session.getAttribute("authority") == 3) { // 권한이 3인 경우
		if(excludeUrl.contains("/health/logout")) {
			response.sendRedirect("/health/index");
			return true; // 로그아웃 페이지에 접속 후 초기페이지로 이동
		}
		response.sendRedirect("/health/index"); // 그 외엔 초기페이지로 이동
		return false;
	}
	if((int)session.getAttribute("authority") == 1) { // 권한이 1인 경우
		if(excludeUrl.contains("/admin/member") 
				|| excludeUrl.contains("/admin/member/search")
				|| excludeUrl.contains("/admin/addr")
				|| excludeUrl.contains("/admin/addr/search")) {
			response.sendRedirect("/health/index");
			return false; // 관리페이지 접근 불가능
		}
	}
}
return true;

멤버이름이 세션에 존재하는 경우,
	1. login, join 주소를 접속하면 index로 우회하고 종료.
	2. 권한이 3(정지)이면서, logout에 접속하는 경우 index로 우회하고 로그아웃 실행.
							이 외의 주소로 접속하는 경우 index로 우회하고 종료.
	3. 권한이 1(일반)이면서, member와 그 검색 또는 addr과 그 검색 에 접속하는 경우 index로 우회하고 종료.
							이 외의 주소로 접속하는 경우 if문을 빠져나가서 해당 주소로 접속됨.
```