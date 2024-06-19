package jungle.simple_board.api;

import jungle.simple_board.dto.MemberDto;
import jungle.simple_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/user")
    public void userJoin(@RequestBody MemberDto memberDto) {
        memberService.join(memberDto);
    }
}
