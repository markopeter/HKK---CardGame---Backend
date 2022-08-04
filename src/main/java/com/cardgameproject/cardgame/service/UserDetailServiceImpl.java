package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.repository.UserRepository;
import com.cardgameproject.cardgame.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private CustomPasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(
            CustomPasswordEncoder passwordEncoder,
                                 UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);
        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}
