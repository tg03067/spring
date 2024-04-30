package com.green.boardver4.comment;

import com.green.boardver4.comment.model.DelCommentReq;
import com.green.boardver4.comment.model.PostCommentReq;
import com.green.boardver4.comment.model.PutCommentReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    int postComment(PostCommentReq p);
    int delComment(DelCommentReq p);
    int putComment(PutCommentReq p);
}
