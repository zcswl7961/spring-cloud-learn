## zipkin server
spring cloud版本在F版本（之后）的时候，已经不需要自己构建zipkin server。如果在F版本之前，可以参考：
[spring cloud C版本构建zipkin server](https://blog.csdn.net/m15231417197/article/details/81540829)
进行构建</br>
spring cloud G版本的 zipkin server 构建参考：[zipkin server 构建](https://blog.csdn.net/wsgsm/article/details/83900135)</br>
[https://blog.csdn.net/zsf4748/article/details/80852264](https://blog.csdn.net/zsf4748/article/details/80852264)




## zipkin server 

启动：java -jar zipkin-server-2.12.2-exec.jar --logging.level.zipkin2=INFO


## zipkin 整合kafka

https://www.cnblogs.com/liangzs/p/9450410.html


官方文档：
https://github.com/openzipkin/zipkin/tree/master/zipkin-server


## zipkin整合 elasticsearch

java -jar zipkin.jar --STORAGE_TYPE=elasticsearch --ES_HOSTS=http://192.168.129.128:9200 --ES_INDEX=zipkin --ES_INDEX_SHARDS=5 --ES_USERNAME=admin --ES_PASSWORD=Admin@123
java -jar zipkin.jar -DSTORAGE_TYPE=elasticsearch -DES_HOSTS=http://192.168.129.128:9200 -DES_INDEX=zipkin -DES_INDEX_SHARDS=5 -DES_USERNAME=admin -DES_PASSWORD=Admin@123