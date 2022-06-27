# EC2
    생성
        인스턴스 - 현재 서버 서울 확인 - 인스턴스(= 객체, 컴퓨터) 시작 - 이름입력, 운영체제 우분투(프리티어 사용 가능한 18.04 버전 선택), 인스턴스 유형 t2.micro(*프리티어 적혀 있는것 확인! 프리티어 : 1년 무료), 키 페어 생성(이름 입력하고 생성) - 다운받은 pem 파일 잘 저장하기(공유X) - 네트워크 설정의 기존 보안 그룹 선택하고 default 선택 - 인스턴스 시작

    설정
        보안그룹 - 인바운드 규칙 - 규칙 편집 - 규칙 추가 - 유형에 SSH - 소스에 0.0.0.0/0 - 설명에 SSH 입력하고 저장
        아웃바운드 규칙도 동일하게 저장

    IP 확인 & IP 고정
        인스턴스 상태 실행중 확인 - 퍼블릭 IP 확인 가능
        탄력적 IP(EIP)도 퍼블릭 IP이다.
        => 퍼블릭 IP지만 컴퓨터를 껐다 키면 IP 변경됨 
        => IP 고정이 필요한 경우, 탄력적IP 클릭 - 탄력적 IP 주소 할당해서 사용 가능(유료)

    배포 준비
        Xmanager 설치 - Xme4 실행&설치
        Xchell(클라우드 컴퓨터와 연결해주는 프로그램) 사용

        파일 - 새로만들기 - 이름 입력 - 호스트에 할당받은 퍼블릭IP 입력
            터미널 - 인코딩 유니코드(UTF-8)로 수정
            모양 - 글꼴 이름 consolas, 크기 12 수정(optional)
            사용자인증 - 방법을 public key로 변경 - 사용자 키를 아까 다운받은 pem파일로 설정 - 사용자 이름에 ubuntu - 확인하고 연결 - 수락 및 저장 - aws EC2 컴퓨터에 연결 완료!
        Ubuntu ROOT 계정 만들기
            1. sudo passwd root 입력하고 비밀번호 2번 입력, password updated successfully 확인
            2. su - 입력하고 비밀번호 입력하면 root로 로그인됨

    필요 프로그램 EC2 내부에 설치
        cd /home : 프로그램은 바탕화면의 home 폴더로 이동해서 설치함
        JDK
            1. apt 업데이트 : sudo apt update 
            2. java 설치 : sudo apt install openjdk-11-jdk 하고 중간에 Y 
            3. java 버전 확인 : javac -version
        톰캣
            1. 설치 : wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.tar.gz
                ls 입력해서 톰캣 확인
            2. 톰캣 압축해제 : tar xf apache-tomcat-9.0.64.tar.gz
                입력방법 : tar xf a까지 입력하고 tab누르면 자동입력됨
            3. mv 명령어로 폴더 이름 변경 : mv a까지 누르고 tab + 한칸 띄우고 tomcat
                => 긴 파일명이 tomcat으로 수정됨
                (원래 mv는 파일 이동 명령어이지만 같은 경로에서 이동시 이름만 바뀜)
            4. cd tomcat 하고 ls 확인
            5. cd bin
                => 현재까지 home/tomcat/bin 경로
                ls 로 파일보면 .sh로 된 파일들이 우분투 실행파일이다(윈도우 exe와 같음)
            7. sg startup.sh 입력하면 톰캣 시작!
            8. 포트 확인 : netstat -tnlp 입력하고 8080 있는지 확인
            9. 연결
                aws 보안그룹 - 인바운드 규칙과 아웃바운드 규칙 추가
                    사용자 지정 TCP - 포트 8080 - 0.0.0.0/0 - 설명 tomcat
                퍼블릭IP:8080 입력하면 톰캣 기본 화면으로 접속됨!
    
    컴파일 준비
        내장 톰캣 제거
            dependencies에 deploy 추가
                providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
            ServletInitializer 상속받아서 BoardApplication 수정
        이클립스 console창 옆의 Gradle Tasks - board - build - clean 더블클릭 - bootWar 더블클릭(board 파일 압축됨) - 내컴퓨터 C드라이브 - workspace - board - build - libs에서 war 파일 확인 가능
    
    배포(war파일 보내고 압축 풀기)
        1. Xshell에서 컴퓨터 연결
            pwd 로 현재 경로 확인 (현재 /home/ubuntu)
        2. 우측상단 새파일전송 클릭(ctrl + alt + f) - ROOT.war 파일 찾아서 원격 컴퓨터로 옮겨줌
            ftp : file transfer protocol(원격에서 파일을 보내는 프로토콜)
            ls로 파일 확인 (ROOT.war 파일 확인)
        3. ROOT로 로그인
            su - 입력
            비밀번호 입력
            pwd 로 경로 확인(/root)
        4. cd /home/ubuntu/
            ls 로 ROOT.war 파일 확인
        5. tomcat 설치 확인
            cd .. 바로 전 폴더로 이동 (/home)
            ls 로 tomcat 확인
        6. cd tomcat
            ls 로 톰캣 내부 파일들 확인
            cd webapps 
            rm -rf * 로 webapps 내 파일 강제로 전체 삭제
                webapps 안에 ROOT 삭제 : 톰캣 기본페이지 삭제
        7. /home/ubuntu 경로로 이동
                /home/tomcat/webapps 에서 cd .. 2번
                cd ubuntu
        8. ubuntu에 있는 ROOT.war 파일을 톰캣의 webapps로 이동
                mv ROOT.war /home/tomcat/webapps/
        9. webapps로 이동해서 파일 확인
            cd /home/tomcat/webapps/
            ls
            webapps 폴더 안에 빨간색 파일의 압축이 풀린 것이 파란색 파일
            파일이 하나만 존재하면(압축이 안 풀렸다면) DB 연결등에서 오류난 것임

        /home/tomcat/logs 경로에서 tail -f catalina.out 입력하면 실시간으로 로그를 보여준다(배포 전 확인용으로 사용)
        나갈 땐 ctrl + c
    
# BeansTalk
    EC2에서 원격컴퓨터에 연결하고, 필요한 프로그램(톰캣, 자바 등) 설치하는 과정을 생략함으로써 쉽게 배포할 수 있게 도와주는 aws 기능
    war 파일만 만들어서 넘겨주면 배포가 가능하다.

    방법
        create application - 플랫폼에서 톰캣 선택 (자바와 톰캣이 설치된 서버가 생성됨) - 이름 지정하고 생성 - 업로드 및 배포에서 ROOT.war 파일 선택(war 파일을 드래그해서 넘기면 됨) - 배포 끝