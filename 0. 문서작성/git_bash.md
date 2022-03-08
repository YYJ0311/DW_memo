bach에서 복사 붙여넣기
ctrl + shift + insert


지금까지 한 것들
1. git remote add upstream 선생님 DW_memo.git 주소
2. git remote -v로 upstream 저장소가 내 PC에 저장된거 확인함
3. git fetch upstream 실행해서 fetch 진행됨
    [new branch] master -> upstream/master 출력됨
4. git checkout master 로 위치 마스터 확인하고
5. git merge upstream/master 로 기존 저장소와 upstream 저장소 합치는데 오류가 남 (fatal: refusing to merge unrelated histories)
6. 푸쉬로 업데이트가 될까 싶어서 git push로 Everything up-to-date 출력됨
7. 여전히 깃허브 업데이트가 안 돼서 git pull origin upstream/master --allow-unrelated-histories 입력했는데 오류 출력됨(fatal: couldn't find remote ref upstream/master)


주의사항
1. 깃허브 주소를 인터넷에서 복사해서 배쉬에다 그냥 붙여넣기 하고 add(또는 푸쉬)했을 때 "protocol 'https' is not supported" 라는 에러 메세지가 출력됐다.
    해결) 인터넷에서 복사한 텍스트에 보이지 않는 문자가 포함되어 있을 수 있다. 그런 경우에 오류가 나온다. 따라서 주소를 복사 붙여넣기 하지 않고 손으로 다 적어서 add 하니까 오류 없어짐.

