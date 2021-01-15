# Sample server
스프링 부트 샘플 서버

## 실행 방법 (with docker)
```
$ ./gradlew build
$ docker build . --tag sample-server
$ docker run -p 8080:8080 sample-server
```

## 실행 방법 (plain)
```
$ ./gradlew build
$ java -jar ./build/libs/*.jar
# OR
$ ./gradlew bootRun
```