package jungle.simple_board.dto;

import jungle.simple_board.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private String name;

    public Member ToEntity() {
        return Member.builder()
                .name(name)
                .build();
    }

}
