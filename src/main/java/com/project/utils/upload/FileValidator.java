package com.project.utils.upload;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return MultipartFile.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors,);   // field-re való validálás

        MultipartFile multipartFile = (MultipartFile) o;

    }
}
