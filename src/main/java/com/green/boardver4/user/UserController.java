package com.green.boardver4.user;

import com.green.boardver4.common.ResultDto;
import com.green.boardver4.user.model.PatchPassword;
import com.green.boardver4.user.model.PostSignIn;
import com.green.boardver4.user.model.PostUser;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping("SignUp")
    public ResultDto<Integer> postUser(@RequestBody PostUser p){
        int result = service.postUser(p);

        return ResultDto.<Integer>builder()
                .httpStatus(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }
    @PostMapping("SignIn")
    public ResultDto<Integer> userSignIn(@RequestBody PostSignIn p){
        int result = service.userSingIn(p);

        String Msg = switch (result){
            case 1 -> "로그인 성공";
            case 2 -> "아이디를 확인해 주세요.";
            case 3 -> "비밀번호를 확인해 주세요.";
            default -> "ERROR";
        };

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(Msg).
                resultData(result).build();
    }
    @PostMapping("PatchPassword")
    public ResultDto<Integer> patchPassword(@RequestBody PatchPassword p){
        int result = service.patchPassword(p);

        String Msg = switch (result){
            case 1 -> "비밀번호 변경 성공";
            case 2 -> "아이디를 확인해 주세요.";
            case 3 -> "현재 비밀번호를 확인해 주세요.";
            default -> "ERROE";
        };

        return ResultDto.<Integer>builder().
                            httpStatus(HttpStatus.OK).
                            resultMsg(Msg).
                            resultData(result).build();
    }
}
