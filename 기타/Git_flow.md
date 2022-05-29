```
대략적인 개념

Git-flow(Git branching model)
    Git이 생긴지 얼마 안 된 2010년에 구상된 개발모델
    브랜치를 나누는 것(branching strategy)과 릴리즈 관리(release management)가 핵심

배민 Git-flow 사용 예
    개발할 것들이 많아지면서 인원과 개발 기간이 늘어남. 
    각각의 인원들은 우선순위가 높은 것을 하나씩 맡아 작업함.
    이런 작업은 브랜치를 나눠서 병렬로 진행되므로 서로 겹치지 않음.
    작업이 완료되면 배포에 포함시켜서 출시함.

    저장소
        팀원 각자의 Local Repository에서 작업
        --push--> 팀원 각자의 Remote Repository 에서 개발자들이 공유하는 저장소인 Upstream 저장소에 pull request함
        --pull request--> 코드리뷰를 거친 후 Upstream Remote Repository에 각자의 작업을 merge 함
        --pull--> 새로운 작업을 하기 위해 Upstream 저장소를 각자의 저장소로 pull하고 반복

    브랜치
        master : 제품으로 출시될 수 있는 브랜치
        develop : 다음 출시 버전을 개발하는 브랜치
        feature : 기능을 개발하는 브랜치
        release : 이번 출시 버전을 준비하는 브랜치
        hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치
```
![](img/git-flow-model.png)


참고  
https://techblog.woowahan.com/2553/
https://nvie.com/posts/a-successful-git-branching-model/