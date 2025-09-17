package com.alibou.security.domain.repository;

import com.alibou.security.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("customUserRepository")
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String name);

}
