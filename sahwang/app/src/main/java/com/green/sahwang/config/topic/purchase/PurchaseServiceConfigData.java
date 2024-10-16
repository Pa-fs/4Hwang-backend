package com.green.sahwang.config.topic.purchase;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "purchase-service")
public class PurchaseServiceConfigData {
    private String purchaseCreatedTopicName;
    private String purchaseCancelledTopicName;
}
