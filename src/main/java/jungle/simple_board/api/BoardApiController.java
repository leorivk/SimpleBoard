package jungle.simple_board.api;

import jungle.simple_board.dto.BoardDto;
import jungle.simple_board.entity.Board;
import jungle.simple_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/")
    public List<BoardDto> boards() {
        List<Board> boards = boardService.findAllBoards();
        return boards.stream()
                .map(BoardDto::new)
                .toList();
    }

    @PostMapping("/board")
    public Long createBoard(@RequestBody BoardDto boardDto) {
        return boardService.create(boardDto);
    }

    @GetMapping("/board/{boardId}")
    public BoardDto updateBoard(@PathVariable("boardId") Long id) {
        Board board = boardService.findBoardById(id);
        return new BoardDto(board);
    }

    @PutMapping("/board/{boardId}")
    public void updateBoard(
            @PathVariable("boardId") Long id,
            @RequestBody BoardDto boardDto) {
        boardService.updateBoard(boardDto, id);
    }

    @DeleteMapping("/board/delete/{boardId}")
    public void deleteBoard(@PathVariable("boardId") Long id) {
        boardService.deleteBoard(id);
    }
}
