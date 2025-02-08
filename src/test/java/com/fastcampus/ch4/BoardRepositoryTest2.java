package com.fastcampus.ch4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest2 {
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @BeforeEach
//    public void testData() {
//        for (int i = 1; i <= 100; i++) {
//            Board board = new Board();
//            board.setBno((long) i);     // Long 타입이라서 명시적 형변환 필요함
//            board.setTitle("title" + i);
//            board.setContent("content" + i);
//            board.setWriter("writer" + (i % 5));    // 작성자는 5명으로 한정해서, 작성자당 여러개의 글쓰게 하기(writer0~4)
//            board.setViewCount((long) (Math.random() * 100));   // 조회수는 랜덤으로(0~99 사이로)
//            board.setInDate(new Date());
//            board.setUpDate(new Date());
//            boardRepository.save(board);    // 엔티티(로우 데이터) 디비에 저장하기
//        }
//    }
//
//    @Test
//    public void countTest() {
//        assertTrue(boardRepository.countAllByWriter("writer1") == 20);
//
//        List<Board> list = boardRepository.findByWriter("writer1");
//        assertTrue(list.size() == 0);
//    }
//
//    @Test
//    public void findTest() {
//        List<Board> list = boardRepository.findByWriter("writer1");
//        assertTrue(list.size() == 20);
//        list.forEach(System.out::println);
//    }
//
//    @Test
//    public void deleteTest() {
//        assertTrue(boardRepository.deleteByWriter("writer1") == 20);
//    }
}