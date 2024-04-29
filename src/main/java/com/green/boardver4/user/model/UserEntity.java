package com.green.boardver4.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String createdAt;
    private String updatedAt;
}
