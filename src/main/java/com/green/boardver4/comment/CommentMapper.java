package com.green.boardver4.comment;

import com.green.boardver4.board.model.GetBoardOne;
import com.green.boardver4.comment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int postComment(PostCommentReq p);
    List<GetCommentRes> getComments(CommentPaging p);
    int getTotalCommentPage(CommentPaging p);
    int delComment(DelCommentReq p);
    int putComment(PutCommentReq p);
    int countComment();
}
