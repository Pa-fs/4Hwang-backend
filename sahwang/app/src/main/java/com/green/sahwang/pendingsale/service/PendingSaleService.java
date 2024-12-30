package com.green.sahwang.pendingsale.service;

import com.green.sahwang.pendingsale.dto.request.PendingSaleCreateReqDto;

public interface PendingSaleService {

    void createPendingSale(PendingSaleCreateReqDto saleCreatedDto, String email);

}
