
//
//@RestController
//@RequestMapping("/auth")
//@AllArgsConstructor
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @Autowired
//    private BankUserRepository bankUserRepository;
//
////    @Autowired
////    public AuthController(AuthService authService, BankUserRepository bankUserRepository) {
////        this.authService = authService;
////        this.bankUserRepository = bankUserRepository;
////    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//
//        BankUser bankUser = bankUserRepository.findByEmail(loginRequest.getEmail());
//        if (bankUser != null && passwordMatches(loginRequest.getPassword(), bankUser.getPassword())) {
//            String token = authService.generateToken((UserDetails) bankUser);
//            return ResponseEntity.ok(token);
//        }
//        return ResponseEntity.status(401).body("Unauthorized");
//    }
//
//    private boolean passwordMatches(String rawPassword, String encodedPassword) {
//        // Здесь должна быть логика для проверки пароля
//        return rawPassword.equals(encodedPassword); // Замените на реальную логику
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<BankUser>> getUsers(@RequestParam int page, @RequestParam int size) {
//        Page<BankUser> users = bankUserRepository.findAll(PageRequest.of(page, size));
//        return ResponseEntity.ok(users.getContent());
//    }
//
//    // Метод для проверки пароля (можно использовать BCrypt)
//}


package com.yurdan.authService.controller.rest;

import com.yurdan.authService.model.LoginRequest;
import com.yurdan.authService.model.entity.BankUser;
import com.yurdan.authService.repository.BankUserRepository;
import com.yurdan.authService.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final BankUserRepository bankUserRepository;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            // Получаем UserDetails для генерации JWT
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
            String jwt = authService.generateToken(userDetails);
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<BankUser> register(@RequestBody BankUser bankUser) {
        // Здесь можно добавить валидацию и проверку на существование пользователя
        BankUser savedUser = bankUserRepository.save(bankUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<BankUser>> getAllUsers() {
        List<BankUser> users = bankUserRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // Можно добавить другие методы для управления пользователями
}