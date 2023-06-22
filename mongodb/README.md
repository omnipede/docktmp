# mongodb

# Run

```shell
$ docker run --rm --name some-mongo \
	-p 27017:27017 \
	-e MONGO_INITDB_ROOT_USERNAME=mongoadmin \
	-e MONGO_INITDB_ROOT_PASSWORD=secret \
	-v /Users/seohyeongyu/Desktop/work/docktmp/mongodb/mongo-init.js:/docker-entrypoint-initdb.d/mongo-init.js:ro \
	mongo
```