package com.pos.shohaib.security.domain.repository;

import com.pos.shohaib.security.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("customUserRepository")
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByName(String name);

}
