package jungle.simple_board.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jungle.simple_board.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public boolean existsByLoginId(String loginId) {
        String jpql = "SELECT COUNT(m) FROM Member m WHERE m.loginId = :loginId";
        Long count = em.createQuery(jpql, Long.class)
                .setParameter("loginId", loginId)
                .getSingleResult();
        return count > 0;
    }

    public Optional<Member> findById(Long id) {
        String jpql = "SELECT m FROM Member m WHERE m.id = :id";
        try {
            Member member = em.createQuery(jpql, Member.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Optional<Member> findByLoginId(String loginId) {
        String jpql = "SELECT m FROM Member m WHERE m.loginId = :loginId";
        try {
            Member member = em.createQuery(jpql, Member.class)
                    .setParameter("loginId", loginId)
                    .getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }




}
