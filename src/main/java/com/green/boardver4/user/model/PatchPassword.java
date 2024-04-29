package com.green.boardver4.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PatchPassword {
    @JsonIgnore
    private long userId;

    private String uid;
    private String newPw;
    private String currentPw;
}
