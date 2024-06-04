package com.example.securitytest.service;

import com.example.securitytest.dto.JoinDTO;
import com.example.securitytest.entity.UserEntity;
import com.example.securitytest.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JoinService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;    // 암호화를 위한 security

    public void joinProcess(JoinDTO joinDTO){

        // 중복 검증 절차 (이미 존재하면 true)
        boolean b = userRepository.existsByUsername(joinDTO.getUsername());
        if (b){
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole("ROLE_ADMIN");


        userRepository.save(data);
    }
}
