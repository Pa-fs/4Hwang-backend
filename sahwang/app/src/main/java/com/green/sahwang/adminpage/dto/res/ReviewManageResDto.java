package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.ReviewManageDto;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewManageResDto {

    private ReviewManageDto reviewManageDto;

    private int favoriteCount;

}
