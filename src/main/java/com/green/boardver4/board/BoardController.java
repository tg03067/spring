package com.green.boardver4.board;

import com.green.boardver4.board.model.*;
import com.green.boardver4.common.model.ResultDto;
import com.green.boardver4.common.model.Paging;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그찍는것.
@RestController
@RequiredArgsConstructor
@RequestMapping("board")
@Tag(name = "Board (게시판)", description = "게시판 CRUD")
public class BoardController {
    private final BoardService service;

    @PostMapping
    @Operation(summary = "게시글 등록", description = "게시글 등록을 할 수 있습니다.")
    public ResultDto<Long> postBoard(@RequestBody PostBoard p){
        log.info("p의 파라미터: {}", p);

        long result = service.postBoard(p);

        return ResultDto.<Long>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("").
                resultData(result).build();
    }
    @DeleteMapping
    public ResultDto<Integer> delBoard(@RequestParam(name = "board_id") PostBoard p){
        int result = service.delBoard(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @PutMapping
    public ResultDto<Integer> putBoard(@RequestBody PutBoard p){
        int result = service.putBoard(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }

    @GetMapping("GetBoardList")
    public ResultDto<List<GetBoardList>> getBoardList(@ModelAttribute Paging boardId){
        List<GetBoardList> list = service.getBoardLists(boardId);

        return ResultDto.<List<GetBoardList>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(String.format("rowCount: %d", list.size())).
                resultData(list).build();
    }

    //http://localhost:8080/board/4
    @GetMapping("{board_id}")
    public ResultDto<GetBoardOne> getBoardOne(@PathVariable(name = "board_id") long p){
        GetBoardOne result = service.getBoardOne(p);

        return ResultDto.<GetBoardOne>builder()
                .httpStatus(HttpStatus.OK)
                .resultMsg(result == null ? "내용을 찾을 수 없습니다." : HttpStatus.OK.toString())
                .resultData(result).build();
    }
}
