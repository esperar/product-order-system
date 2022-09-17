package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.policy.DiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean
    OrderService orderService(MemberRepository memberRepository , DiscountPolicy discountPolicy){
        return new OrderServiceImpl(memberRepository,discountPolicy);
    }

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}


