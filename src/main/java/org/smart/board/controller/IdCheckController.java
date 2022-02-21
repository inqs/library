package org.smart.board.controller;

import org.smart.board.entity.Member;
import org.smart.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdCheckController {
    @Autowired
    MemberService memberService;

    @PostMapping("/account/idCheck")
    @ResponseBody
    public boolean idCheck(String usrid){
        Member member = memberService.findOne(usrid); // null이 오면 가입 가능한 아이디
        System.out.println("멤버: " + member);
        if(member == null)
            return true;
        return false; //false는 사용 불가능한 아이디
    }
}
