package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> findAll();

    UserRole save(UserRole userRole);

    UserRole update(UserRole userRole);

    UserRole findById(Integer userRoleId);

    void deleteById(Integer userRoleId);

}