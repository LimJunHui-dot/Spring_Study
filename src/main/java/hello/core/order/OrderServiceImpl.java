package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 의존관계를 필드에 직접 주입
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@Autowired
    //public void setMemberRepository(MemberRepository memberRepository){
    //    this.memberRepository = memberRepository;
    //}

    //@Autowired
    //public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //    this.discountPolicy = discountPolicy;
    //}


    // Qualifier를 지저분하게 붙여야 한다
    // ex. Database Connection과 관련된 정보인데 Main DataBase와 보조 DataBase가 있다고 해보자.
    // 메인 데이터베이스의 로직이 90%이고 보조 데이터베이스는 어쩌다 5%,10%도 안되는 로직이 있다.
    // 메인 데이터베이스를 가져오는 커넥션을 할때 Qualifier를 해주고 보조를 가져올 때도 Qualifier를 해준다,
    // 메인 데이터베이스 커넥션을 가져오는 그런 코드에는 primary를 미리 걸어준다.


    //new OrderServiceImpl();
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
