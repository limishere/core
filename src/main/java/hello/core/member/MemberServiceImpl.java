package hello.core.member;

//구현체가 한개만 있을 경우, 관례상 인터페이스명+Impl로 파일명 작성함
public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //이렇게하면 문제가 있는데, MemberServiceImpl는 MemberRepository 인터페이스에 의존함과 동시에
    //실제 할당하는 부분이 구현체인 MemoryMemberRepository에도 의존함(DIP를 위반)
    // 나중에 변경이 있을 때 문제가 될 수 있음

    private final MemberRepository memberRepository;

    //생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //join해서 save를 호출하면 다형성에 의해서
        //MemoryMemberRepository에 있는 오버라이드한 save가 호출된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
