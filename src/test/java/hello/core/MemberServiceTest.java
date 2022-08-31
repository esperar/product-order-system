package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerivce;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberSerivce memberSerivce = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L ,"memberA", Grade.BASIC);

        //when
        memberSerivce.join(member);
        Member findMember = memberSerivce.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
