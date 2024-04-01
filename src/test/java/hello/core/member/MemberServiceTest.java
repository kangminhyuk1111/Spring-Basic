package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println(findMember);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void deleteMember() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        memberService.deleteMember(findMember);

        Assertions.assertThat(memberService.findMember(member.getId())).isEqualTo(null);
    }
}
