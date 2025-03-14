package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // ComponentScan으로 다 뒤져서 스프링 빈으로 자동 등록하는데 그중에 다 뺄거를 지정해주는 것
        //basePackages = "hello.core.member",
        //basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

   /* @Autowired MemberRepository memberRepository;
    @Autowired
    DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/
}
