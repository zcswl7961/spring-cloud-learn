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