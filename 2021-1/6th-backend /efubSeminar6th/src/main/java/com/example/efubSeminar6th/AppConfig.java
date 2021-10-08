package com.example.efubSeminar6th;

import com.example.efubSeminar6th.discount.DiscountPolicy;
import com.example.efubSeminar6th.discount.FixDiscountPolicy;
import com.example.efubSeminar6th.member.MemberRepository;
import com.example.efubSeminar6th.member.MemberService;
import com.example.efubSeminar6th.member.MemberServiceImpl;
import com.example.efubSeminar6th.member.MemoryMemberRepository;
import com.example.efubSeminar6th.order.OrderService;
import com.example.efubSeminar6th.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//⭐️구현 객체 생성, 연결하는 책임
@Configuration //빈 등록 하기 위해, 설정을 구성한다는 뜻
public class AppConfig {

    @Bean //각각 스프링 컨테이너에 스프링 빈으로 등록
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }


    //생성자 안에 들어가는 구현 객체를 여기서 지정?
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }




}
