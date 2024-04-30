package com.green.boardver4.comment.model;

import lombok.Data;

@Data
public class PostCommentReq {
    private String commentContents;
    private long writerId;
    private long commentId;
}
