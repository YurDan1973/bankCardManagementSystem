package com.yurdan.authService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yurdan.authService.model.entity.BankUser;

public interface BankUserRepository extends JpaRepository<BankUser, String> {
    BankUser findByEmail(String email);
}
