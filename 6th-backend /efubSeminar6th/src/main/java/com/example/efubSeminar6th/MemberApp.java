package com.example.efubSeminar6th;

import com.example.efubSeminar6th.member.Grade;
import com.example.efubSeminar6th.member.Member;
import com.example.efubSeminar6th.member.MemberService;
import com.example.efubSeminar6th.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //1) 기본 java 코드
        //MemberService memberService = new MemberServiceImpl();


         //2) AppConfig 이용 (필요한 객체 직접 조회)
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService= appConfig.memberService();

        //3) ⭐️Spring Container (=Application Context)
        // @Configuration,
        // @Bean 이용 => @Bean이라 적힌 메소드를 모두 호출헤서 반화나된 객체를 Spring Container에 등록함, 이 등록된 개체가 Bean
        // 필요한 객체를 applicationContext.getBean()을 통해 찾음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());

        System.out.println("find Member = " + findMember.getName());

    }
}
