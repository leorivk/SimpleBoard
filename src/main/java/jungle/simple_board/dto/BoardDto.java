package jungle.simple_board.dto;

import jungle.simple_board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String date;
    private String name;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public BoardDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        content = board.getContent();
        date = board.getDate().format(formatter);
        name = "현수";
    }

    public Board ToEntity() {
        return new Board(title, content);
    }

}
