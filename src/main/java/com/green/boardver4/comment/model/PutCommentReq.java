package com.green.boardver4.comment.model;

import lombok.Data;

@Data
public class PutCommentReq {
    private long commentId;
    private long writerId;
    private String commentContents;
}
