### 基于OpenFeign进行服务间的调度


Feign 调用：引入对应的Feign定义的接口模块： spring-common-feign
```
        <dependency>
            <groupId>com.zcswl.spring</groupId>
            <artifactId>spring-common-feign</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

同时，配置 spring-cloud-starter-openfeign 模块：
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-okhttp</artifactId>
        </dependency>
```

后端代码中，使用@EnableFeignClients(basePackages = {"xxxx"}) 进行加载对应的Feign 接口<br/>

其中xxx引入的是Feign接口定义的包路径<br/>

