package com.green.sahwang.adminpage.dto.res;

import com.green.sahwang.adminpage.dto.CategoryManageDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryManageResDto {

    private List<CategoryManageDto> categoryManageDtoPage;

    private int count;

}
