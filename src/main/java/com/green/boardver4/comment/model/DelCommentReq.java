package com.green.boardver4.comment.model;

import lombok.Data;

@Data
public class DelCommentReq {
    private long commentId;
    private long writerId;
}
