package jungle.simple_board.service;

import jungle.simple_board.dto.JoinRequest;
import jungle.simple_board.dto.LoginRequest;
import jungle.simple_board.entity.Member;
import jungle.simple_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * loginId 중복 체크
     */
    public boolean isLoginIdTaken(String loginId) {
        return memberRepository.existsByLoginId(loginId);
    }

    /**
     * 회원가입
     */
    public Boolean join(JoinRequest request) {
        if (!isLoginIdTaken(request.getLoginId())) {
            memberRepository.save(request.ToEntity());
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 로그인 기능
     */
    public Member login(LoginRequest request) {
        Optional<Member> optionalMember = memberRepository.findByLoginId(request.getLoginId());

        if (optionalMember.isEmpty()) {
            return null;
        }

        Member member = optionalMember.get();

        if (!member.getPassword().equals(request.getPassword())) {
            return null;
        }

        return member;
    }

    /**
     * id 입력받아 Member 반환
     */
    public Member getLoginMemberById(Long id) {
        if (id == null) return null;

        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElse(null);
    }

    /**
     * loginId 입력받아 Member 반환
     */
    public Member findMemberByLoginId(String loginId) {
        if (loginId == null) return null;

        Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);
        return optionalMember.orElse(null);
    }
}
