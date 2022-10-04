package com.javatodev.api.config;

import com.javatodev.api.model.User;
import com.javatodev.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppInitializer implements SmartInitializingSingleton {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void afterSingletonsInstantiated() {
        User basicUser = new User(1L, "john", this.passwordEncoder.encode("john"));
        basicUser.addAuthorities("READ");
        userRepository.save(basicUser);
        User writeUser = new User(2L, "peter", this.passwordEncoder.encode("peter"));
        writeUser.addAuthorities("WRITE");
        userRepository.save(writeUser);
    }
}
