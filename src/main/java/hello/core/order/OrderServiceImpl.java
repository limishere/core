package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //회원찾기용
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //할인정책
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    //생성자
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //Final이 붙은 변수는 상수이므로 보통은 선언과 동시에 초기화를 하지만,
    //클래스의 경우 생성자에서 초기화 할 수 있다.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보를 찾아서
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인정책에 회원정보를 넘김

        //할인가격을 받아서, 최종생성된 주문을 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
