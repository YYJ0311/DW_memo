```
스프링을 이용한 배포는 ubuntu 내에 설치한 tomcat/webapps 폴더 안에서 war파일의 압축을 해제해서 배포했다.
파일이름은 ROOT.war여야만 자동으로 압축이 풀어지고 배포되었다.

이번에는 파일이름을 다르게 하여 압축을 풀어봤다.
일단 board.war 라는 파일을 ubuntu에 넣고 tomcat/webapps 폴더로 옮겨줬다.(tomcat 폴더에 바로 접근 불가능)
ROOT.war라면 tomcat에 넣었을 때 자동으로 압축이 풀리지만 파일명이 달라서 압축을 풀기위한 추가설정이 필요하다.
압축풀기
    1. cd /home/tomcat/conf 로 이동
    2. vi server.xml 로 파일 읽기
    3. i 눌러서 편집모드로 전환 후, <host> 태그 안에 다음 코드 추가
        <Context path="/" docBase="board" reloadable="false" > </Context>
        => path는 경로인데 /로 설정, docBase는 파일이름이다.
    4. esc를 눌러서 편집모드를 종료하고, :wq 로 파일 밖으로 나온다.
    5. cd /home/tomcat/bin 로 이동
    6. ./shutdown.sh 로 톰캣을 종료하고 ./startup.sh 로 톰캣을 재시작한다.
    7. cd /home/tomcat/webapps 로 이동해서 보면 board.war 파일의 압축이 풀려있을 것이다.
```
```
근데 이렇게 파일명이 다른 상태로 압축을 풀게되면 문제점이 하나 발생한다.
주소에 경로가 추가되면서 jsp에 연결이 되지 않는 건데,
원래 IP:port/board?pageNum=1&pageSize=10 주소로 연결 되어야 할 것이 위 방법으로 하니까
IP:port/board/?pageNum=1&pageSize=10 이렇게 board와 ? 사이에 /가 추가되어 제대로 접속되지 않았다....
근데 이해가 안 되는 건 board를 제외한 /students?pageNum=1&pageSize=10 나 /logs?pageNum=1&pageSize=20 로는 접속이 잘 됐다.. 파일 이름이 board라서 board에만 위에서 설정한 / 경로가 추가된 건가?? 모르겠다.
그래서 일단 tomcat/webapps 폴더로 가서 mv board.war ROOT.war로 파일명 바꾸는 걸로 끝냈다.
```