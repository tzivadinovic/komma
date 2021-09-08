package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Role;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}