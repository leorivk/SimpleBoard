package jungle.simple_board.dto;

import jungle.simple_board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardDto {

    private String title;
    private String content;
    private LocalDateTime date;

    public BoardDto(Board board) {
        title = board.getTitle();
        content = board.getContent();
        date = board.getDate();
    }

    public Board ToEntity() {
        return new Board(title, content);
    }

}
