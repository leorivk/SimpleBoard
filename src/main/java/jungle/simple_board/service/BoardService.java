package jungle.simple_board.service;

import jungle.simple_board.dto.BoardDto;
import jungle.simple_board.dto.CommentDto;
import jungle.simple_board.entity.Board;
import jungle.simple_board.entity.Comment;
import jungle.simple_board.repository.BoardRepository;
import jungle.simple_board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public Long create(BoardDto boardDto) {
        Board board = boardDto.ToEntity();
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public Board findBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateBoard(BoardDto boardDto, Long id) {
        Board board = boardRepository.findById(id);
        board.updateBoard(boardDto);
        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.remove(id);
    }

    // == 댓글 == //
    public Long createComment(CommentDto commentDto) {
        Comment comment = commentDto.ToEntity();
        commentRepository.save(comment);
        return comment.getId();
    }

    public List<Comment> findCommentsByBoardId(Long boardId) {
        return commentRepository.findCommentsByBoardId(boardId);
    }
}
