package com.green.boardver4.user;

import com.green.boardver4.user.model.PatchPassword;
import com.green.boardver4.user.model.PostSignIn;
import com.green.boardver4.user.model.PostUser;
import com.green.boardver4.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
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

    public int userSingIn(PostSignIn p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null){ //아이디를 확인해 주세요.
            return 2;
        }
        if(BCrypt.checkpw(p.getUpw(), entity.getUpw())){ //로그인 성공.
            return 1;
        }
        return 3; // 비밀번호 다름.
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
