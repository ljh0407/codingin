package codingin.controller;

import codingin.domain.entity.MemberEntity;
import codingin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/member")
public class MemberController {
    //=============================================//
    @Autowired
    private MemberService memberService;
    //=============================================//
    @GetMapping("/index")    //인덱스 html 불러오기
    public Resource getindex(){
        return new ClassPathResource("templates/index.html");
    }
}
