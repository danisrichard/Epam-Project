package com.project.service.Impl;

import com.project.error.NotFoundThisMobileException;
import com.project.model.mobilesection.Mobile;
import com.project.model.mobilesection.ResponseMobile;
import com.project.repository.MobilePhoneRepository;
import com.project.service.MobileFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PhoneFinderServiceImpl implements MobileFinderService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @Override
    public Page<Mobile> getAllByPage(Pageable pageable) {
       return mobilePhoneRepository.findAll(pageable);
    }

    @Override
    public ResponseMobile getPhoneMessage(Long id) throws NotFoundThisMobileException {
        Mobile concreteMobile = mobilePhoneRepository.findById(id).orElseThrow(NotFoundThisMobileException::new);

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
