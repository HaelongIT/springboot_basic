package com.fastcampus.ch4;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @Column(name="cart_id")
    private Long id;

    @OneToOne       // FK가 생김
    @JoinColumn(name="member_id", nullable = false)     // 필수값으로 만들기 => inner join을 사용 => 성능 향상
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
//                ", member=" + member +
                '}';
    }
}
