package com.zcswl.spring.gateway.filter.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * spring cloud gateway 自定义filter
 * @author zhoucg
 * @date 2019-11-22 16:54
 */
public class RequestTimeFilter implements GatewayFilter,Ordered  {


    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";


    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        serverWebExchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        return gatewayFilterChain.filter(serverWebExchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = serverWebExchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null) {
                        log.info(serverWebExchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
