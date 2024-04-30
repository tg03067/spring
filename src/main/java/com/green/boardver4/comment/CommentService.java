package com.green.boardver4.comment;

import com.green.boardver4.comment.model.DelCommentReq;
import com.green.boardver4.comment.model.PostCommentReq;
import com.green.boardver4.comment.model.PutCommentReq;
import com.green.boardver4.user.UserMapper;
import com.green.boardver4.user.model.PostSignIn;
import com.green.boardver4.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
