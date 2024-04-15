package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링을 사용하는 버전으로 변경하기!
        //ApplicationContext 를 스프링 컨테이너라 한다.(객체들을 다 관리해줌 @Bean)
        //AppConfig 클래스에 있는 환경설정 정보를 가지고,
        //스프링이 클래스 안에 있는 @Bean이 붙은 메서드를 모두 호출해서 반환된 객체를 스프링컨테이너에 넣어 관리해준다.
        //스프링 컨테이너에 등록된 객체를 스프링 빈이라 함
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //getBean("메서드이름", 반환타입.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        //가입한 멤버와 findMember가 같으면 구현에 문제 없음
        System.out.println("new member = " + member.getName()); //new member = memberA
        System.out.println("find Member = " + findMember.getName()); //find Member = memberA

        /**
        애플리케이션 로직으로 이렇게 테스트 하는 것은 좋은 방법이 아니다. JUnit 테스트를 사용하자.
        */

    }
}
