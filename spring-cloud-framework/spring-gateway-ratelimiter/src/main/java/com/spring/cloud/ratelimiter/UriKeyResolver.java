//package com.spring.cloud.ratelimiter;
//
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * 通过url
// **/
//public class UriKeyResolver  implements KeyResolver {
//
//    @Override
//    public Mono<String> resolve(ServerWebExchange exchange) {
//        return Mono.just(exchange.getRequest().getURI().getPath());
//    }
//
//    @Bean
//    public UriKeyResolver uriKeyResolver() {
//        return new UriKeyResolver();
//    }
//
//}
