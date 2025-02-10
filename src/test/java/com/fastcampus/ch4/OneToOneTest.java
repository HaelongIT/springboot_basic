package com.fastcampus.ch4;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OneToOneTest {

//    @Autowired
//    public EntityManager em;
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Test
//    public void oneToOneTest() {
//        // 멤버 엔티티 디비에 저장
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("aaa");
//        member.setEmail("aaa@aaa.com");
//        member.setPassword("1234");
//        memberRepository.save(member);
//
//        // 카트 엔티티 디비에 저장
//        Cart cart = new Cart();
//        cart.setId(1L);
//        cart.setMember(member);
//        cartRepository.save(cart);
//
//        Cart findCart = cartRepository.findById(cart.getId()).orElse(null);      // 저장한 카트 엔티티 디비에서 조회해서 가져오기
//        assertTrue(findCart != null);
//        System.out.println("findCart = " + findCart);
//
//        Member findMember = memberRepository.findById(member.getId()).orElse(null);
//        assertTrue(findMember != null);
//        System.out.println("findMember = " + findMember);
//    }
}