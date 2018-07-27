package com.project.service;

import com.project.error.NotFoundThisMobileException;
import com.project.model.mobilesection.Mobile;
import com.project.model.mobilesection.ResponseMobile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MobileFinderService {
    ResponseMobile getPhoneMessage(Long id) throws NotFoundThisMobileException;

    Page<Mobile> getAllByPage(Pageable pageable);
}
