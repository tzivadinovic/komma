package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.ChangePasswordDTO;
import com.tzivadinovic.komma.exception.PasswordsNotMatchesException;
import com.tzivadinovic.komma.repository.RoleRepository;
import com.tzivadinovic.komma.repository.UserRepository;
import com.tzivadinovic.komma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDisplayName(String.format("%s %s", user.getFirstName(), user.getLastName()));
        user.setRoles(roleRepository.findAllByRole("AUTHOR")); //default
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElseThrow(NoSuchElementException::new);
        user.setDisplayName(String.format("%s %s", existingUser.getFirstName(), existingUser.getLastName()));
        user.setPassword(existingUser.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User changeUserPassword(User user, ChangePasswordDTO dto) {
        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new PasswordsNotMatchesException();
        } else if (!dto.getNewPassword().equals(dto.getRepeatedPassword())) {
            throw new PasswordsNotMatchesException.RepeatedAndNewPasswordDontMatches();
        } else {
            user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        }
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }
}



