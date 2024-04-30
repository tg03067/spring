package com.green.boardver4.comment;

import com.green.boardver4.comment.model.*;
import com.green.boardver4.common.model.Paging;
import com.green.boardver4.common.model.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    private ResultDto<List<GetCommentRes>> getComments(@ModelAttribute CommentPaging p){
        List<GetCommentRes> list = service.getComments(p);
        String Msg = String.format("row: %d", list.size());
        if(p.getSize() > 0 && p.getSize() > list.size()){
            Msg += String.format(", total: %d", (p.getPage() - 1) * p.getSize() + list.size());
        }
        //p.getSize() != list.size()
        //(p.getPage() - 1) * p.getSize() + list.size() = countComment
        return ResultDto.<List<GetCommentRes>>builder().
                                        httpStatus(HttpStatus.OK).
                                        resultMsg(Msg).
                                        resultData(list).build();
    }
}