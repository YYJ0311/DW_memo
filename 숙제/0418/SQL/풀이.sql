1. 차량 수 조회
select count(*)
from car_information

2. 차량에 부착된 디바이스 uuid, battery, create_at 조회.
select 
	c.device_uuid,
	d.battery,
	c.create_at 
from car_information c
join devices d 
on c.device_uuid = d.device_uuid 

3. UUID '20130099', 배터리 100, 펌웨어 버전 '1.0.1', 사용여부 TRUE인 디바이스를 devices에 등록하시오.
INSERT INTO devices(device_uuid, battery, firmware_ver, is_use) VALUES('20130099', 100, '1.0.1', TRUE);

4. 2022-04-11 이후 탈착 이벤트가 1건 이상 발생된 UUID, 펌웨어 버전 조회.
select
	ci.device_uuid,
	d.firmware_ver
from car_information ci
join car_event_log cel
on ci.car_number = cel.car_number 
join devices d 
on ci.device_uuid = d.device_uuid 
where cel.event_type = 3 
and 
cel.create_at >= '2022-04-11'

5. 2022-04-11 ~ 2022-04-13 일별 이벤트 카운트 조회. 
select 
	case when create_at >= '2022-04-11' and create_at < '2022-04-12' then '2022-04-11' 
	when create_at >= '2022-04-12' and create_at < '2022-04-13' then '2022-04-12'
	when create_at >= '2022-04-13' then '2022-04-13'
	else null end as 일자,
	count(*)
from car_event_log
group by 일자

6. 전체 디바이스 수, 차량에 부착된 디바이스 수, 차량에 부착하지 않은 디바이스 수 조회.
select 
	count(d.device_uuid) as '전체 디바이스 수',
	count(c.device_uuid) as '차량에 부착된 디바이스 수',
	count(수정필요) as '차량에 부착하지 않은 디바이스 수'
from devices d 
left join car_information c
on d.device_uuid = c.device_uuid

7. 차량번호 '359서 9096'의 2022-04-11 ~ 2022-04-13일까지 이벤트별 카운트 조회
select
	cel.event_type as '이벤트 번호', 
	count(cel.event_type) as '개수'
from car_information ci 
join car_event_log cel 
on ci.car_number = cel.car_number 
where cel.create_at >= '2022-04-11' 
and
cel.create_at <= '2022-04-13'
and
ci.car_number = '359서 9096'
group by cel.event_type

8. UUID가 '20133344'인 디바이스의 2022-04-11 ~ 2022-04-13에 발생한 이벤트타입, 이벤트 날짜, 차량번호판, 담당자 조회.
select
	cel.event_type as '이벤트 타입',
	cel.create_at as '이벤트 날짜',
	cel.car_number as '차량번호판',
	ci.admin_name as '담당자' 
from car_information ci 
join car_event_log cel 
on ci.car_number = cel.car_number 
where cel.create_at >= '2022-04-11' 
and
cel.create_at <= '2022-04-13'
and 
ci.device_uuid = '20133344'