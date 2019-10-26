package com.batuhanozdamar.eproductionTest.repository;

import com.batuhanozdamar.eproductionTest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
