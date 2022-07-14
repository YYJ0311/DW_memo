```
특정 쿼리를 찾아서 active 클래스를 전부 지운 뒤 클릭한 쿼리에만 active 클래스를 주는 코드
```
```html
<ul class="nav">
    <li><a href="#home" class="active"><i class="fa fa-home"></i>Home</a></li>
    <li><a href="#about"><i class="fa fa-user"></i>About</a></li>
    <li><a href="#services"><i class="fa fa-list"></i>Services</a></li>
    <li><a href="#portfolio"><i class="fa fa-briefcase"></i>Portfolio</a></li>
    <li><a href="#contact"><i class="fa fa-comments"></i>Contact</a></li>
</ul>
```
```javascript
const nav = document.querySelector(".nav"), // nav를 갖는 요소 선택
navList = nav.querySelectorAll("li"), // nav에 있는 li 모두 선택
totalNavList = navList.length; // li들의 길이
for(let i=0; i<totalNavList; i++){
    const a = navList[i].querySelector("a") // li에서 a태그를 변수 a에 담음
    a.addEventListener("click", function(){ // a태그가 클릭되면
        for(let j=0; j<totalNavList; j++){
            navList[j].querySelector("a").classList.remove("active"); // a 태그를 가진 모든 li에서 active 클래스 제거
        }
        this.classList.add("active") // 클릭한 a태그에 active 클래스 추가
    })
}
```