package jungle.simple_board.dto;

import jungle.simple_board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDto {

    private String title;
    private String content;

    public BoardDto() {
    }

    public BoardDto(Board board) {
        title = board.getTitle();
        content = board.getContent();
    }

    public Board ToEntity() {
        return new Board(title, content);
    }

}
