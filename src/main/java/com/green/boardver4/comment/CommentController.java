package com.green.boardver4.comment;

import com.green.boardver4.comment.model.DelCommentReq;
import com.green.boardver4.comment.model.PostCommentReq;
import com.green.boardver4.comment.model.PutCommentReq;
import com.green.boardver4.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {
    private final CommentService service;

    @PostMapping
    public ResultDto<Integer> postComment(@RequestBody PostCommentReq p){
        int result = service.postComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }

    @DeleteMapping
    public ResultDto<Integer> delComment(@ModelAttribute DelCommentReq p){
        int result = service.delComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }

    @PutMapping
    public ResultDto<Integer> putComment(@RequestBody PutCommentReq p){
        int result = service.putComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
}
