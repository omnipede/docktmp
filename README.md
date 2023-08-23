# docktmp
자주 사용하는 docker file, docker-compose 를 정리한 repository

# tips
```shell
$ docker rmi $(docker images -q)
$ docker rm $(docker ps -a -q)
$ docker container prune -f
$ docker image prune -f
$ docker volume prune -f
```
