package com.green.sahwang.usedproduct.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VerifiedAndUserSaleImageResDto {

    private String fileDesc;
    private String filename;
    private String path;
    private String type;

}
