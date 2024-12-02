package com.green.sahwang.inspection.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaleResImage {

    private Long pendingSaleId;
    private String name;
    private String path;
    private String desc;
}
