package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션의 전체 동작 방식을 구성(config)하기 위해,
 * 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
 *
 * AppConfig는
 * 1)애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 * 2)생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
 */

@Configuration //설정정보
public class AppConfig {

    @Bean //@Bean을 기재하면 스프링컨테이너에 등록된다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
