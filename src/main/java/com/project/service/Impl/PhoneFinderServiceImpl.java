package com.project.service.Impl;

import com.project.model.Mobile;
import com.project.model.ResponseMobile;
import com.project.repository.MobilePhoneRepository;
import com.project.service.MobileFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PhoneFinderServiceImpl implements MobileFinderService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @Override
    public ResponseMobile getPhoneMessage(Long id) throws IllegalStateException {
        Optional<Mobile> mobile = mobilePhoneRepository.findById(id);

        Mobile concreteMobile = mobile.get();

        HashMap<String,String> mobileField = new HashMap<>();

        String type = handleNullFieldValue(concreteMobile.getMobileType());
        String manufacture = handleNullFieldValue(concreteMobile.getManufacture());
        String desc = handleNullFieldValue(concreteMobile.getDesc());
        String releaseDate = handleNullFieldValue(concreteMobile.getReleaseDate());

        mobileField.put("type",type);
        mobileField.put("manufacture",manufacture);
        mobileField.put("desc",desc);
        mobileField.put("releaseDate",releaseDate);

        List<String> sentenceList = getSentenceList(mobileField);

        return new ResponseMobile.Builder()
                                .sentenceValue(String.join(" ", sentenceList))
                                .titleValue(String.join(" ", manufacture, type))
                                .build();
    }

    private List<String> getSentenceList(HashMap<String, String> mobileEquipment) {
        return mobileEquipment.entrySet().stream()
                                .map(entry -> getSentence(entry.getValue(), entry.getKey()))
                                .collect(Collectors.toList());
    }

    private String getSentence(String text, String propertyPosition) {
        return messageSource.getMessage(propertyPosition, new Object[]{text}, Locale.ENGLISH);
    }

    private String handleNullFieldValue(String mobileType) {
        return mobileType != null ? mobileType : "";
    }
}
