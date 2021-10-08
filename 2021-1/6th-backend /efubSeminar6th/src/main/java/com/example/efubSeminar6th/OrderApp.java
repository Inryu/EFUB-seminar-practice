package com.example.efubSeminar6th;

import com.example.efubSeminar6th.member.Grade;
import com.example.efubSeminar6th.member.Member;
import com.example.efubSeminar6th.member.MemberService;
import com.example.efubSeminar6th.member.MemberServiceImpl;
import com.example.efubSeminar6th.order.Order;
import com.example.efubSeminar6th.order.OrderService;
import com.example.efubSeminar6th.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        //1)기본 java이용
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        //2)AppConfig에서 관리
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService=appConfig.memberService();
//        OrderService orderService=appConfig.orderService();

        //3) ⭐️Spring Container (=Application Context)
        // @Configuration,
        // @Bean 이용 => @Bean이라 적힌 메소드를 모두 호출헤서 반화나된 객체를 Spring Container에 등록함, 이 등록된 개체가 Bean
        // 필요한 객체를 applicationContext.getBean()을 통해 찾음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService",OrderService.class);

        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
