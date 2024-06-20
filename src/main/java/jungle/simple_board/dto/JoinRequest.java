package jungle.simple_board.dto;

import jungle.simple_board.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    private String loginId;

    private String password;

    private String name;

    /* 비밀번호 암호화 */
    public Member ToEntity() {
        return Member.builder()
                .loginId(this.loginId)
                .password(this.password)
                .name(this.name)
                .build();
    }

}
