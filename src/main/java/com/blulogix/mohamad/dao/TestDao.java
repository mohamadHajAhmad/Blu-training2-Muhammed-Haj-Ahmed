package com.blulogix.mohamad.dao;


import com.blulogix.mohamad.entity.TestEntity;
import com.blulogix.mohamad.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDao {
    @Autowired
    private TestRepo testRepo;
    public Iterable<TestEntity> test() {
        return this.testRepo.findAll();
    }
}
