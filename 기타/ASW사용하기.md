```
클라우드 사용 이전엔 서버를 사고 장비도 사고 공간도 필요하고 사람도 필요했다.
비용을 절감하고 애자일 방식을 사용하기 위해 클라우드를 사용한다.
    ==> 스타트업 99퍼센트는 클라우드 사용
    ==> AWS와 백엔드를 모두 다룰 수 있는(DevOps) 사람의 필요성이 커짐
        DevOps = 개발(Development) + 운영(Operation)
회사는 클라우드에서 내가 만든 걸 컨트롤할 수 있는지를 본다.

MLOps(Machine Learning + Operation) (데이터 분석+운영) 이라는 말도 생김.

웹의 종류
    정적 웹 : HTML, JS, JQuery (백엔드 소스가 없음)
    동적 웹 : 프레임워크 + 템플릿엔진 으로 개발 (우리는 spring boot 와 jsp)
    차이 : DB에 연동할 수 있냐 없냐 차이
    
    AWS의 S3는 정적 웹만 호스팅 가능하다

S3 (Simple Storage Service)
    1. 이미지(영상) 전용 서버로 많이 사용함
    2. 백업 서버로 사용
    3. 웹 호스팅 서버로 사용 (수업에서 사용)
        (호스팅 = 빌리는 것)
        => s3를 임대해서 내 HTML을 S3에 업로드 할 것임
    
    특징 : 저장 공간이 무한
    가격 : 시간당 저장 용량만큼 가격 책정 (* 5기가 이하는 1년간 공짜!)

    사용 방법
        AWS 홈페이지 - 서비스 - S3 - 버킷 만들기
        버킷 이름 작성 - 버킷 만들기 - 버킷 들어가서 업로드
    추가 설정
        기본적으로는 사진 업로드 기능만 있어서 웹 사이트 호스팅 설정 수정이 필요하다.
        1. 웹 호스팅 설정 변경
            객체 옆 속성 - 정적 웹 사이트 호스팅 편집 - 활성화
            인덱스 문서에 index.html 입력 - 저장
        2. 모든 사람이 볼 수 있게 변경
            권한 - 퍼블릭 액세스 차단 - 편집 - 차단해제(비활성)하고 저장
        3. 버킷 정책 입력
                {
                    "Version": "2012-10-17",
                    "Statement": [
                        {
                            "Effect": "Allow",
                            "Principal": "*",
                            "Action": "s3:*",
                            "Resource": "arn:aws:s3:::버킷이름/*"
                        }
                    ]
                }
            
            버킷 정책에 관한 내용
            https://docs.aws.amazon.com/ko_kr/AmazonS3/latest/userguide/example-bucket-policies.html

    업로드 후 속성 최하단에 도메인 주소 확인 가능하다.
```
```
공짜 도메인 주소 배급해주는 사이트
cloud flare
https://www.cloudflare.com/
```