package jungle.simple_board.dto;

import jungle.simple_board.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;


import static org.mindrot.jbcrypt.BCrypt.hashpw;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    private String loginId;

    private String password;

    private String name;

    /**
     * 비밀번호 해시
     */
    public static String hashPassword(String plainTextPassword) {
        return hashpw(plainTextPassword, BCrypt.gensalt());
    }

    /* 비밀번호 암호화 */
    public Member ToEntity() {
        return Member.builder()
                .loginId(this.loginId)
                .password(hashPassword(this.password))
                .name(this.name)
                .build();
    }

}
