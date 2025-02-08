package com.fastcampus.ch4;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    // !!!!!!연관 관계 맵핑하기 - 다대일!!!!!!!

}
