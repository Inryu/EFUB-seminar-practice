package com.example.efubSeminar6th.order;

import com.example.efubSeminar6th.discount.DiscountPolicy;
import com.example.efubSeminar6th.discount.FixDiscountPolicy;
import com.example.efubSeminar6th.member.Member;
import com.example.efubSeminar6th.member.MemberRepository;
import com.example.efubSeminar6th.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {


//    //java 코드로는 직접 구현체로 생성
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //Rete정책으로 바꾸려면 이곳을 수정해야함.


    // FixDiscountPolicy에 의존하지 않고, discountPolicy 인터페이스에만 의존하게 되게 수정!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //회원 정보 조회
        Member member = memberRepository.findById(memberId);

        //할인 정책
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
