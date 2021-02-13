package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //MemberService memberService = new MemberServiceImpl();
        // 기존에는 직접 객체를 생성햇지만 appconfig를 통해 인터페이스에 의존

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        // Appconfig로 DI 컨테이너 역할


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // Spring 이용 (Appcontext = 스프링 컨테이너)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
