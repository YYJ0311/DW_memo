```
웹에서 카카오맵을 사용하기 위한 방법

카카오개발자
    애플리케이션 -> 애플리케이션 추가하기
    앱이름, 사업자명 입력하고 저장하고 클릭
    해당 애플리케이션의 플랫폼 - web - 사이트 도메인에 IP주소:포트번호(http://192.168.0.240:5501) 입력함

카카오 맵
    구글에 카카오맵 api 검색 - 카카오 지도 API 사이트 - web - sample - 마커 생성하기 - Javascript + HTML 선택

    카카오 개발자 - 앱 키 - javascript 키 복사해서 아래 주소 중간에 입력
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 사용하세요"></script>

    body에 지도 구역 만듦
    <div id="map" style="width:100%;height:350px;"></div> 

    그 아래 나머지 코드들 넣으면 지도 생성완료!
```

```javascript
예시

<div class="input-box">
    <div id="map" style="width:100%;height:300px;"></div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY"></script>
<script>
    function getPopup(logId){
        $.ajax({
            url : "http://localhost:8080/api/v1/logs/logId/"+ logId, 
            // logId별로 latitude와 longitude를 받아서 카카오맵을 띄울 것임
            type : "GET",
            dataType : "json",
            success : function (response){
                $('.logs-popup').css('display', 'block');
                var latitude = response.latitude;
                var longitude = response.longitude;

                //  카카오맵
                var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                mapOption = { 
                    center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };
            
                var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
            
                // 마커가 표시될 위치입니다 
                var markerPosition  = new kakao.maps.LatLng(latitude, longitude); 
            
                // 마커를 생성합니다
                var marker = new kakao.maps.Marker({
                    position: markerPosition
                });
            
                // 마커가 지도 위에 표시되도록 설정합니다
                marker.setMap(map);
            }
        })
    }
</script>
```