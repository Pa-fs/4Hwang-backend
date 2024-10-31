package com.green.sahwang.dto.request.externalapi;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.green.sahwang.config.LocalDateTimeDeserializer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExternalPaymentReqDto {

    private String buyerEmail;

    @NotNull
    @JsonProperty(value = "merchant_uid")
    private String merchantUid;

    @NotNull
    @JsonProperty(value = "imp_uid")
    private String impUid;

    @JsonProperty(value = "pay_method")
    private String payMethod;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime paidAt;

    private String embPgProvider;

    private String pgProvider;

    private String status;

    private BigDecimal amount;

}
