package com.sample.api.repository;

import com.sample.api.dto.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
