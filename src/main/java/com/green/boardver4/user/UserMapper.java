package com.green.boardver4.user;

import com.green.boardver4.user.model.PatchPassword;
import com.green.boardver4.user.model.PostUser;
import com.green.boardver4.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(PostUser p);
    UserEntity getUserById(String uid);
    int patchPassword(PatchPassword p);
}
