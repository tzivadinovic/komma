package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.*;
import com.tzivadinovic.komma.repository.UserRoleRepository;
import com.tzivadinovic.komma.service.UserRoleService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
	private final UserRoleRepository userRoleRepository;

	@Override
	public List<UserRole> findAll() {
		return userRoleRepository.findAll();
	}

	@Override
	public UserRole findById(Integer userRoleId) {
		return userRoleRepository.findById(userRoleId)
				.orElseThrow(() -> new NoSuchElementException("UserRoleService.notFound"));
	}

	@Override
	public UserRole save(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public UserRole update(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public void deleteById(Integer userRoleId) {
		userRoleRepository.deleteById(userRoleId);
	}


}