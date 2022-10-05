package com.javatodev.api.service;

import com.javatodev.api.model.User;

public interface UserService {

    User findByUserName(String userName);

}
