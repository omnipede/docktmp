# PROMETHEUS & GRAFANA 를 이용한 서버 모니터링 세팅

## 개요
Prometheus 와 Grafana 를 이용한 서버 모니터링 시스템을 세팅하기 편하도록 dockerize 함.
* Prometheus: 서버로부터 메트릭을 가져오는 (스크래핑하는) 서버
* Grafana: prometheus 가 가져온 서버 메트릭을 시각화해주는 서버

## 실행 방법
```
# 기본 실행방법
$ docker-compose up

# 백그라운드 실행방법
$ docker-compose up -d
```

## Grafana 접속방법
* 브라우저를 통해 ```http://localhost:3000``` 접속
* 계정정보는 ```docker-compose.yml``` 파일의 ```services.grafana.environment``` 참조

## Prometheus 설정 방법
* 설정파일은 ```prometheus/prometheus.yml``` 에 존재
```yaml
# JOB
  - job_name: 'job'
    metrics_path: '/actuator/prometheus'
    scrape_interval: 5s
    static_configs:
      - targets: ['YOUR_HOST_IP:YOUR_PORT']
    basic_auth:
      username: 'foobar'
      password: 'foobar'
```
```scrape_config``` 에 위와 같이 job 을 추가한다
* static_configs[].targets 에 메트릭을 가져올 대상 서버 주소를 작성
* metrics_path 에 메트릭이 노출된 endpoint 를 작성
* 만약 메트릭이 노출된 엔드포인트에 접근할 때 인증이 필요하면 basic_auth 에 계정정보를 넣어준다 (필요 없으면 안넣어도 됨)

## Grafana 에 prometheus 를 등록하는 방법
* 좌측 메뉴 ```Configuration``` > ```Data sources``` > ```Add data source``` > ```Prometheus``` 선택
* Http > URL > ```http://prometheus:9090``` 입력  
docker-compos.yml 에서 grafana 컨테이너와 prometheus 컨테이너를 network 로 연결하고 있어서 위와 같은 http 접속이 가능하다
* 하단의 ```Save & Test``` 클릭

## Dashboard 추가방법
* ```https://grafana.com/grafana/dashboards/6756``` 접속 > ```Copy ID to clipboard``` 클릭해서 복사
* ```http://localhost:3000``` 접속
* 좌측 메뉴 ```Create``` > ```Import``` 클릭
* ```Import via grafana.com``` 입력란에 복사한 내용 붙여넣기 > ```Load``` 클릭
* ```Prometheus``` > 등록했던 prometheus datasource 추가 > ```Import``` 클릭