package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.ReviewManageDto;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewManageResDto {

    private Page<ReviewManageDto> reviewManageDtos;

    private int reviewCount;

}
