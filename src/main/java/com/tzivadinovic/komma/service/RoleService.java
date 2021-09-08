package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role save(Role role);

    Role update(Role role);

    Role findById(Integer roleId);

    void deleteById(Integer roleId);

}