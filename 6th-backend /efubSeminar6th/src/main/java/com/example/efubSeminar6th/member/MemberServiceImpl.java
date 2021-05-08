package com.example.efubSeminar6th.member;

public class MemberServiceImpl implements MemberService {

//  private final MemberRepository memberRepository=new MemoryMemberRepository();
    // MemoryMemberRepository를 의존하지 않고, 오직 MemberRepository 인터페이스만 의존하도록 수정.

    private final MemberRepository memberRepository;

   // 생성자를 통해 어떤 구현객체를 주입할 지는 오직 외부 (AppCopfig)에서 결정!

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
