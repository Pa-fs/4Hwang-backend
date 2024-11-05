package com.green.sahwang.detail.dto.response;

import com.green.sahwang.dto.response.ImageResDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailImagesResDto {

    private List<ImageResDto> images;
}
