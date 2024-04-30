package hello.core.beanfind;

import hello.core.Appconfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationCotextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
}

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByname2() {
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName(("빈 이름으로 조회X"))
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        //예외가 던져지면 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx", MemberService.class));
    }
}