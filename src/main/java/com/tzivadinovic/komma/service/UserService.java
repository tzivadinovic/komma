package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.ChangePasswordDTO;
import com.tzivadinovic.komma.entity.dto.RegisterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    User save(RegisterDTO dto);

    User save(User user);

    User update(User user);

    User findById(Integer userId);

    void deleteById(Integer userId);

    User changeUserPassword(User user, ChangePasswordDTO dto);

}