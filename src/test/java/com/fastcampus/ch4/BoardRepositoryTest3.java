package com.fastcampus.ch4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest3 {

    @Autowired
    public EntityManager em;

    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    public void testData() {
        for (int i = 1; i <= 100; i++) {
            Board board = new Board();
            board.setBno((long) i);     // Long 타입이라서 명시적 형변환 필요함
            board.setTitle("title" + i);
            board.setContent("content" + i);
            board.setWriter("writer" + (i % 5));    // 작성자는 5명으로 한정해서, 작성자당 여러개의 글쓰게 하기(writer0~4)
            board.setViewCount((long) (Math.random() * 100));   // 조회수는 랜덤으로(0~99 사이로)
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepository.save(board);    // 엔티티(로우 데이터) 디비에 저장하기
        }
    }

    @Test
    @DisplayName("createQuery로 JPQL작성 테스트")
    public void createQueryTest() {
        String query = "SELECT b FROM Board b";
        TypedQuery<Board> tQuery = em.createQuery(query, Board.class);
        List<Board> list = tQuery.getResultList();

        list.forEach(System.out::println);
        assertTrue(list.size() == 100);
    }

    @Test
    @DisplayName("@Query로 JPQL작성 테스트")
    public void queryAnnoTest() {
        List<Board> list = boardRepository.findAllBoard();
        assertTrue(list.size() == 100);
    }

    @Test
    @DisplayName("@Query로 JPQL작성 테스트 - 매개변수 순서")
    public void queryAnnoTest2() {
//        @Query("SELECT b FROM Board b WHERE b.title=?1 AND b.writer=?2")
        List<Board> list = boardRepository.findByTitleAndWriter2("title1", "writer1");
        list.forEach(System.out::println);
        assertTrue(list.size() == 1);
    }

    @Test
    @DisplayName("@Query로 JPQL작성 테스트 - 매개변수 이름")
    public void queryAnnoTest3() {
//        @Query("SELECT b FROM Board b WHERE b.title=:title AND b.writer=:writer")
//        List<Board> findByTitleAndWriter3(String title, String writer);
        List<Board> list = boardRepository.findByTitleAndWriter3("title1", "writer1");
        list.forEach(System.out::println);
        assertTrue(list.size() == 1);
    }

    @Test
    @DisplayName("@Query로 네이티브 쿼리(SQL) 작성 테스트 - 전체 컬럼을 조회하는 경우")
    public void queryAnnoTest4() {
//        @Query(value = "SELECT * FROM Board", nativeQuery = true)
//        List<Board> findAllBoardBySQL();
        List<Board> list = boardRepository.findAllBoardBySQL();
        assertTrue(list.size() == 100);
    }

    @Test
    @DisplayName("@Query로 네이티브 쿼리(SQL) 작성 테스트 - 일부 컬럼을 조회하는 경우")
    public void queryAnnoTest5() {
//        @Query(value = "SELECT TITLE, WRITER FROM Board", nativeQuery = true)
//        List<Object[]> findAllBoardBySQL2();
        List<Object[]> list = boardRepository.findAllBoardBySQL2();
//        list.forEach(System.out::println);
        list.stream()   // list를 stream으로 변환
                .map(arr -> Arrays.toString(arr))   // arr을 String으로 변환
                .forEach(System.out::println);
        assertTrue(list.size() == 100);
    }
}