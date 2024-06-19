package jungle.simple_board.repository;

import jakarta.persistence.EntityManager;
import jungle.simple_board.entity.Board;
import jungle.simple_board.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    /** 생성 **/
    public void save(Comment comment) {
        em.persist(comment);
    }

    /** 조회 **/
    public List<Comment> findCommentsByBoardId(Long boardId) {
        return em.createQuery("SELECT c FROM Comment c WHERE c.board.id = :boardId", Comment.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }

}
