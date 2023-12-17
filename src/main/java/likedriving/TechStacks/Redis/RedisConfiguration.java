package likedriving.TechStacks.Redis;

import lombok.Data;

import java.util.List;

@Data
public class RedisConfiguration {

    private Integer idleConnectionTimeout;
    private Integer connectTimeout;
    private Integer timeout;
    private Integer retryAttempts;
    private Integer retryInterval;
    private Integer failedSlaveReconnectionInterval;
    private Integer failedSlaveCheckInterval;
    private String password;
    private Integer subscriptionsPerConnection;
    private String clientName;
    private String loadBalancer;
    private Integer subscriptionConnectionMinimumIdleSize;
    private Integer subscriptionConnectionPoolSize;
    private Integer slaveConnectionMinimumIdleSize;
    private Integer slaveConnectionPoolSize;
    private Integer masterConnectionMinimumIdleSize;
    private Integer masterConnectionPoolSize;
    private String readMode;
    private String subscriptionMode;
    private List<String> nodeAddresses;
    private Integer scanInterval;
    private Integer pingConnectionInterval;
    private boolean keepAlive;
    private boolean tcpNoDelay;
}
