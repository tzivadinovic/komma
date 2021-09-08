package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.UserRole;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}