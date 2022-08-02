package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.Users;
import com.cardgameproject.cardgame.model.UserModel;

public interface UserService {
    Users registerUser(UserModel userModel);

    void saveVerificationTokenForUser(Users user, String token);

    String validateVerificationToken(String token);
}
