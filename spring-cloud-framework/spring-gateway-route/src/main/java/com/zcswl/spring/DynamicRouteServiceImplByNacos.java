package com.zcswl.spring;

import cn.hutool.json.JSONUtil;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.utils.JSONUtils;
import com.zcswl.spring.nacos.NacosGatewayProperties;
import com.zcswl.spring.route.DynamicRouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author xingyi
 * @date 2023/3/9
 */
@Component
public class DynamicRouteServiceImplByNacos implements CommandLineRunner {


    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Autowired
    private NacosGatewayProperties nacosGatewayProperties;

    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener (){
        try {
            ConfigService configService= NacosFactory.createConfigService(nacosGatewayProperties.getAddress());
            String content = configService.getConfig(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), nacosGatewayProperties.getTimeout());
            System.out.println(content);
            configService.addListener(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    // just find other message
                    List<RouteDefinition> list = JSONUtil.toList(configInfo, RouteDefinition.class);
                    list.forEach(definition->{
                        dynamicRouteService.update(definition);
                    });
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        dynamicRouteByNacosListener();

    }
}
