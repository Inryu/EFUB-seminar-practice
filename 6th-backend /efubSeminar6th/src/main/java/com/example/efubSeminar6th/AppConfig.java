package com.example.efubSeminar6th;

import com.example.efubSeminar6th.discount.DiscountPolicy;
import com.example.efubSeminar6th.discount.FixDiscountPolicy;
import com.example.efubSeminar6th.member.MemberRepository;
import com.example.efubSeminar6th.member.MemberService;
import com.example.efubSeminar6th.member.MemberServiceImpl;
import com.example.efubSeminar6th.member.MemoryMemberRepository;
import com.example.efubSeminar6th.order.OrderService;
import com.example.efubSeminar6th.order.OrderServiceImpl;


//⭐️구현 객체 생성, 연결하는 책임
public class AppConfig {

    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }


    //생성자 안에 들어가는 구현 객체를 여기서 지정?
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }




}
