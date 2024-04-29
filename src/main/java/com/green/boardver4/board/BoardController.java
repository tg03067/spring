package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import com.green.boardver4.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping("InsertBoard")
    public ResultDto<Integer> postBoard(@RequestBody PostBoard p){
        int result = service.postBoard(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @DeleteMapping("DelBoard")
    public ResultDto<Integer> delBoard(@RequestParam(name = "board_id") PostBoard p){
        int result = service.delBoard(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @PutMapping("PutBoard")
    public ResultDto<Integer> putBoard(@RequestBody PutBoard p){
        int result = service.putBoard(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @GetMapping("GetBoardList")
    public ResultDto<List<GetBoardList>> getBoardList(@ModelAttribute PageBoard boardId){
        List<GetBoardList> list = service.getBoardLists(boardId);

        return ResultDto.<List<GetBoardList>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(String.format("rowCount: %d", list.size())).
                resultData(list).build();
    }
    @GetMapping("{board_id}")
    public ResultDto<GetBoardOne> getBoardOne(@PathVariable(name = "board_id") long p){
        GetBoardOne result = service.getBoardOne(p);

        return ResultDto.<GetBoardOne>builder()
                .httpStatus(HttpStatus.OK)
                .resultMsg(result == null ? "내용을 찾을 수 없습니다." : HttpStatus.OK.toString())
                .resultData(result).build();
    }
}
