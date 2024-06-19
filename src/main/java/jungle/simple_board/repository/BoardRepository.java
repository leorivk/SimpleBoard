package jungle.simple_board.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jungle.simple_board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    /** 생성 **/
    public void save(Board board) {
        em.persist(board);
    }

    /** 조회 **/
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

}
