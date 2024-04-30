package com.green.boardver4.comment;

import com.green.boardver4.comment.model.*;
import com.green.boardver4.common.model.ResultDto;
import com.green.boardver4.user.UserMapper;
import com.green.boardver4.user.model.PostSignIn;
import com.green.boardver4.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper mapper;

    public int postComment(PostCommentReq p){
        return mapper.postComment(p);
    }
    public int delComment(DelCommentReq p){
        // 로그인한 사용자의 pk값을 p에 대입
        return mapper.delComment(p);
    }
    public int putComment(PutCommentReq p){
        // 로그인한 사용자의 pk값을 p에 대입
        return mapper.putComment(p);
    }
    public List<GetCommentRes> getComments(CommentPaging p){
        return mapper.getComments(p);
    }
    public int countComment(){
        return mapper.countComment();
    }
}
