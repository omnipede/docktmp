# fluentd

https://hub.docker.com/r/fluent/fluentd/

# Run fluentd

```shell
$ docker build -t fluentd .
$ docker run --rm \
  -u root \
  -p 24224:24224 \
  -v /Users/seohyeongyu/Desktop/work/docktmp/fluentd/fluent.conf:/fluentd/etc/fluent.conf \
  fluentd
```

# Use cases
https://www.fluentd.org/guides

# Docker 로그 수집

`fluentd` 를 실행한 상태로 다음과 로그를 수집할 컨테이너를 실행하면 된다.

```shell
$ docker run --rm --log-driver=fluentd --log-opt tag="docker.{{.ID}}" ubuntu echo 'Hello Fluentd!'
```

<img width="1162" alt="스크린샷 2023-06-22 오후 2 32 48" src="https://github.com/omnipede/docktmp/assets/41066039/c230e947-2bae-4e2e-9dca-acf4789b9ce1">

# k8s 로그 수집

https://kubernetes.io/docs/concepts/cluster-administration/logging/#sidecar-container-with-a-logging-agent