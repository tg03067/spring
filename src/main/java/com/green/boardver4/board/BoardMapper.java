package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int postBoard(PostBoard p);
    int delBoard(PostBoard p);
    int putBoard(PutBoard p);
    List<GetBoardList> getBoardList(PageBoard p);
    GetBoardOne getBoardOne(long boardId);
    int patchBoardHits(long p);
}
