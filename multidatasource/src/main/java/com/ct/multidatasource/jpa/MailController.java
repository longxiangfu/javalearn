package com.ct.multidatasource.jpa;

import com.ct.multidatasource.jpa.first.domain.PrimaryEntity;
import com.ct.multidatasource.jpa.first.repository.PrimaryRepository;
import com.ct.multidatasource.jpa.second.domain.SecondaryEntity;
import com.ct.multidatasource.jpa.second.repository.SecondaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/database")
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PrimaryRepository primaryRepository;

    @Autowired
    SecondaryRepository secondaryRepository;


    @RequestMapping("/primary")
    @ResponseBody
    public String primary() {
        List<PrimaryEntity> list = primaryRepository.queryList();
        if (!CollectionUtils.isEmpty(list)) {
            System.out.println(Arrays.toString(list.toArray()));
        }else {
            return "fail";
        }
        return "ok";
    }

    @RequestMapping("/secondary")
    @ResponseBody
    public String secondary() {
        List<SecondaryEntity> list = secondaryRepository.queryList();
        if (!CollectionUtils.isEmpty(list)) {
            System.out.println(Arrays.toString(list.toArray()));
        }else {
            return "fail";
        }
        return "ok";
    }

}
