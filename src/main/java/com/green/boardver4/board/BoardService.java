package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public int postBoard(PostBoard p){
        return mapper.postBoard(p);
    }
    public int delBoard(PostBoard p){
        return mapper.delBoard(p);
    }
    public int putBoard(PutBoard p){
        return mapper.putBoard(p);
    }
    public List<GetBoardList> getBoardLists(PageBoard p){
        return mapper.getBoardList(p);
    }

    public GetBoardOne getBoardOne(long boardId){
        GetBoardOne result = mapper.getBoardOne(boardId);
        if(result != null){
            mapper.patchBoardHits(boardId);
        }
        return result;
    }
}
