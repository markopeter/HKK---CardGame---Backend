package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.Users;
import com.cardgameproject.cardgame.entity.VerificationToken;
import com.cardgameproject.cardgame.model.UserModel;
import com.cardgameproject.cardgame.repository.UserRepository;
import com.cardgameproject.cardgame.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, VerificationTokenRepository verificationTokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public Users registerUser(UserModel userModel) {
        Users user = new Users();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(Users users, String token) {
        VerificationToken verificationToken = new VerificationToken(users, token);
        verificationTokenRepository.save(verificationToken);
    }
}
