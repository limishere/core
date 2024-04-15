package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
JUnit 테스트
*/
public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    @BeforeEach //테스트 코드에서 @BeforeEach 는 각 테스트를 실행하기 전에 호출된다.
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        //org.assertj.core.api.Assertions;
        //실행해서 녹색체크표시가 뜨면 테스트 이상 없음! 성공

    }

}
