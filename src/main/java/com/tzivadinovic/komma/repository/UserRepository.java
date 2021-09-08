package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}