package com.example.securitytest.controller;

import com.example.securitytest.dto.JoinDTO;
import com.example.securitytest.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinP(){

        return "join";
    }

    // 회원가입 완료시 => 로그인페이지
    // 실패시 => 다시 회원가입 페이지
    @PostMapping("/joinProc")
    public String joinProcess(JoinDTO joinDTO){

        joinService.joinProcess(joinDTO);

        return "redirect:/login";
    }
}
