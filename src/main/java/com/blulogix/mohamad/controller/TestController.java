package com.blulogix.mohamad.controller;

import com.blulogix.mohamad.dao.TestDao;
import com.blulogix.mohamad.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestDao testDao;
    @GetMapping("/test")
    public Iterable<TestEntity> test() {
        return testDao.test();
    }
}
