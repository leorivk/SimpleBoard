package jungle.simple_board.dto;

import jungle.simple_board.entity.Comment;

public class CommentDto {

    private String content;

    public Comment ToEntity() {
        return new Comment(this.content);
    }
}
