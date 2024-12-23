package com.green.sahwang.detail.dto.response;

import com.green.sahwang.dto.response.ImageResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailImagesResDto {

    private List<ImageResDto> images;
}
