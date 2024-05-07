package com.blulogix.mohamad.repository;

import com.blulogix.mohamad.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<TestEntity , Integer> {
}
