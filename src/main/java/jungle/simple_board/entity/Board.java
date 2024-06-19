package jungle.simple_board.entity;

import jakarta.persistence.*;
import jungle.simple_board.dto.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    public void updateBoard(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.date = LocalDateTime.now();
    }
}
