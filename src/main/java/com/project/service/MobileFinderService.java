package com.project.service;

import com.project.error.NotFoundThisMobileException;
import com.project.model.ResponseMobile;

public interface MobileFinderService {
    ResponseMobile getPhoneMessage(Long id) throws NotFoundThisMobileException;
}
