package com.green.boardver4.user;

import com.green.boardver4.common.model.ResultDto;
import com.green.boardver4.user.model.PatchPassword;
import com.green.boardver4.user.model.PostSignIn;
import com.green.boardver4.user.model.PostUser;
import com.green.boardver4.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(PostUser p){
        String hashPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashPassword);
        return mapper.postUser(p);
    }

    public ResultDto<Long> userSingIn(PostSignIn p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null){ //아이디를 확인해 주세요.
            return ResultDto.<Long>builder().
                httpStatus(HttpStatus.NOT_FOUND).
                resultMsg("아이디를 확인해 주세요.").
                resultData(0L).build();
        } else if(!BCrypt.checkpw(p.getUpw(), entity.getUpw())){ //비밀번호를 확인해 주세요.
            return  ResultDto.<Long>builder().
                httpStatus(HttpStatus.NOT_FOUND).
                resultMsg("비밀번호를 확인해 주세요.").
                resultData(0L).build();
        }

        return  ResultDto.<Long>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("로그인 성공").
                resultData(entity.getUserId()).build();
    }

    public int patchPassword(PatchPassword p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null){
            return 2; // 아이디를 확인해 주세요.
        } else if (!BCrypt.checkpw(p.getCurrentPw(), entity.getUpw())) {
            return 3; //비밀번호를 확인해 주세요.
        }
        // 비밀번호 변경
        String hashPassword = BCrypt.hashpw(p.getNewPw(), BCrypt.gensalt());
        p.setNewPw(hashPassword);
        p.setUserId(entity.getUserId());
        return mapper.patchPassword(p);
    }
}
