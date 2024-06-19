package jungle.simple_board.api;

import jungle.simple_board.dto.BoardDto;
import jungle.simple_board.entity.Board;
import jungle.simple_board.repository.BoardRepository;
import jungle.simple_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/api/boards")
    public List<BoardDto> boards() {
        List<Board> boards = boardService.findAllBoards();
        return boards.stream()
                .map(BoardDto::new)
                .toList();
    }
    @PostMapping("/api/boards")
    public void createBoard(@RequestBody BoardDto boardDto) {
        boardService.create(boardDto.ToEntity());
    }

}
