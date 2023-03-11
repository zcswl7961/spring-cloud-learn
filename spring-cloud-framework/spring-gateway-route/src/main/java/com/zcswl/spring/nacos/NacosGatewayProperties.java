package com.zcswl.spring.nacos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * curruent nacos dynamic configuration properties
 * @author xingyi
 * @date 2023/3/9
 */
@ConfigurationProperties(prefix="nacos", ignoreUnknownFields = true)
@Configuration
public class NacosGatewayProperties {

    private String address;

    private String dataId;

    private String groupId;

    private Long timeout;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
}
