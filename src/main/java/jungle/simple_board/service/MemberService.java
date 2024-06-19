package jungle.simple_board.service;

import jungle.simple_board.dto.MemberDto;
import jungle.simple_board.entity.Member;
import jungle.simple_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(MemberDto memberDto) {
        Member member = memberDto.ToEntity();
        memberRepository.save(member);
    }
}
