package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import com.green.boardver4.comment.CommentMapper;
import com.green.boardver4.comment.model.CommentPaging;
import com.green.boardver4.comment.model.GetCommentRes;
import com.green.boardver4.common.GlobalConst;
import com.green.boardver4.common.model.Paging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;
    private final CommentMapper commentMapper;

    public long postBoard(PostBoard p){
        log.info("(1)p.boardId: {}", p.getBoardId());
        long result = mapper.postBoard(p);
        log.info("(2)p.boardId: {}", p.getBoardId());
        if(result == 0){
            return 0L;
        }
        return p.getBoardId();
    }
    public int delBoard(PostBoard p){
        return mapper.delBoard(p);
    }
    public int putBoard(PutBoard p){
        return mapper.putBoard(p);
    }
    public List<GetBoardList> getBoardLists(Paging p){
        return mapper.getBoardList(p);
    }

    public GetBoardOne getBoardOne(long boardId){
        GetBoardOne result = mapper.getBoardOne(boardId);
        if(result != null){
            mapper.patchBoardHits(boardId);
        }
        CommentPaging paging = new CommentPaging(1, GlobalConst.COMMENT_PAGING_SIZE, boardId);
        List<GetCommentRes> comments = commentMapper.getComments(paging);
        result.setComments(comments);
        if(comments.size() < GlobalConst.COMMENT_PAGING_SIZE){
            result.setTotalCommentPage(1);
        } else {
            int totalCommentPage = commentMapper.getTotalCommentPage(paging);
            result.setTotalCommentPage(totalCommentPage);
        }
        return result;
    }
}
