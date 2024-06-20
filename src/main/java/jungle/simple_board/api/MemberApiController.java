package jungle.simple_board.api;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jungle.simple_board.dto.JoinRequest;
import jungle.simple_board.dto.LoginRequest;
import jungle.simple_board.entity.Member;
import jungle.simple_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> joinUser(@RequestBody JoinRequest joinRequest) {
        if (memberService.join(joinRequest)) {
            return ResponseEntity.ok("회원가입 성공");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패: 이미 존재하는 사용자입니다.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Member member = memberService.login(loginRequest);

        Cookie cookie = new Cookie("id", member.getId().toString());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);

        response.addCookie(cookie);
        return ResponseEntity.ok("success");
    }

}
