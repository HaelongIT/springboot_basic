package com.fastcampus.ch4;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    @Order(1)
    public void insertTest() {
        Board board = new Board();
//        board.setBno(null);
        board.setBno(1L);
        board.setTitle("Test Title");
        board.setContent("This is Test");
        board.setWriter("aaa");
        board.setViewCount(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());

        boardRepository.save(board);
    }

    @Test
    @Order(2)
    public void selectTest() {
        // Board board = boardRepository.findById(1L).get();   // 값이 없을 때 예외발생
        Board board = boardRepository.findById(1L).orElse(null);    // 값이 없을 때 null 반환
        System.out.println("board = " + board);

        assertTrue(board != null);
    }

    @Test
    @Order(3)
    public void updateTest() {
        Board board = boardRepository.findById(1L).orElse(null);        // 못찾으면 null 반환
        assertTrue(board != null);

        board.setTitle("modified Title");
        boardRepository.save(board);

        Board board2 = boardRepository.findById(1L).orElse(new Board());    // 못찾으면 새로운 board 객체(엔티티) 반환
        System.out.println("board = " + board);
        System.out.println("board2 = " + board2);


        assertTrue(board.getTitle().equals(board2.getTitle()));
    }

    @Test
    @Order(4)
    public void deleteTest() {
        boardRepository.deleteById(1L);     // 1번 게시물 삭제

        Board board = boardRepository.findById(1L).orElse(null);    // 못찾으면 null 반환
        assertTrue(board == null);      // 삭제됐으니까 null이여야 함(검증하기)
    }
}