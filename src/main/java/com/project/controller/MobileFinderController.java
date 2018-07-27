package com.project.controller;

import com.project.error.NotFoundThisMobileException;
import com.project.model.mobilesection.Mobile;
import com.project.service.MobileFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;


@Controller
@RequestMapping("/mobile")
@SessionScope
public class MobileFinderController {

    @Autowired
    private MobileFinderService mobileFinderService;

    @GetMapping("/get/{id}")
    public String getMobilePhone(Model model, @PathVariable Long id) throws NotFoundThisMobileException {
        try {
            model.addAttribute("phone", mobileFinderService.getPhoneMessage(id));
        } catch (Exception e) {
            throw new NotFoundThisMobileException();
        }
        return "mobile-section/mobile-index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Page<Mobile> listOfMobile(@PageableDefault(size = 3, direction = Sort.Direction.DESC) Pageable pageable) {
        return mobileFinderService.getAllByPage(pageable);
    }
}
