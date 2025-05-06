package com.yurdan.authService.controller.rest;

import com.yurdan.authService.model.LoginRequest;
import com.yurdan.authService.model.entity.BankUser;
import com.yurdan.authService.repository.BankUserRepository;
import com.yurdan.authService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private BankUserRepository bankUserRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        BankUser bankUser = bankUserRepository.findByEmail(loginRequest.getEmail());
        if (bankUser != null && passwordMatches(loginRequest.getPassword(), bankUser.getPassword())) {
            String token = authService.generateToken((UserDetails) bankUser);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    private boolean passwordMatches(String rawPassword, String encodedPassword) {
        // Здесь должна быть логика для проверки пароля
        return rawPassword.equals(encodedPassword); // Замените на реальную логику
    }

    @GetMapping("/users")
    public ResponseEntity<List<BankUser>> getUsers(@RequestParam int page, @RequestParam int size) {
        Page<BankUser> users = bankUserRepository.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok(users.getContent());
    }

    // Метод для проверки пароля (можно использовать BCrypt)
}
