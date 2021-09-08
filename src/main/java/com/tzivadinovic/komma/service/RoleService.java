package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.*;
import java.util.Collection;
import java.util.List;

public interface RoleService {

	List<Role> findAll();

	Role save(Role role);

	Role update(Role role);

	Role findById(Integer roleId);

	void deleteById(Integer roleId);

}