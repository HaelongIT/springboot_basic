package com.fastcampus.ch4;

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

    // !!!!!!!Querydsl!!!!!!!

    // !!!!!!연관 관계 맵핑하기 - 다대일!!!!!!!

}
