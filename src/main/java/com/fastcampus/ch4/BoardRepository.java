package com.fastcampus.ch4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    // !!!!!!!쿼리 메서드!!!!!!
    // SELECT COUNT(*) FROM BOARD WHERE WRITER = :writer
//     int countBoardAllByWriter(String writer);
    int countAllByWriter(String writer);

    // SELECT * FROM BOARD WHERE WRITER = :writer
//    List<Board> findBoardByWriter(String writer);
    List<Board> findByWriter(String writer);

    // SELECT * FROM BOARD WHERE TITLE = : title AND WRITER = :writer
//    List<Board> findBoardByTitleAndWriter(String title, String writer);
    List<Board> findByTitleAndWriter(String title, String writer);

    // DELETE FROM BOARD WHERE WRITER = :writer
//    int deleteBoardByWriter(String writer);
    @Transactional      // delete의 경우, 여러 건을 delete 할 수 있기 때문에 Tx처리가 필수적임
    int deleteByWriter(String writer);

    // !!!!!!!JPQL + 네이티브 쿼리!!!!!!!
    @Query("SELECT b FROM Board b")     // JPQL은 명칭(예약어 제외)을 대소문자 구분함에 주의
    List<Board> findAllBoard();     // 메서드 이름은 아무거나 상관없음(쿼리 메서드와 차이점)

    @Query("SELECT b FROM Board b WHERE b.title=?1 AND b.writer=?2")
    List<Board> findByTitleAndWriter2(String title, String writer);

    @Query("SELECT b FROM Board b WHERE b.title=:title AND b.writer=:writer")
    List<Board> findByTitleAndWriter3(String title, String writer);

    @Query(value = "SELECT * FROM Board", nativeQuery = true)
    List<Board> findAllBoardBySQL();

    @Query(value = "SELECT TITLE, WRITER FROM Board", nativeQuery = true)
    List<Object[]> findAllBoardBySQL2();

    // !!!!!!!Querydsl!!!!!!!

    // !!!!!!연관 관계 맵핑하기 - 다대일!!!!!!!

}
