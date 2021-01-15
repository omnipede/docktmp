# nginx
nginx proxy docker-compose 샘플

## 실행 방법
1. ```../sample-server``` 디렉토리로 이동

2. 샘플 서버 이미지 빌드

```
$ docker build . --tag sample-server
```

3. 다시 nginx 디렉토리로 복귀하여 docker-compose 실행

```
$ docker-compose up
``` 