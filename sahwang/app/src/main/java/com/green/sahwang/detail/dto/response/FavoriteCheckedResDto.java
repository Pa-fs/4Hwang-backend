package com.green.sahwang.detail.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteCheckedResDto {
    Long reviewId;
    Boolean checked;

}
