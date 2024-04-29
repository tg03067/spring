package com.green.boardver4.board.model;

import lombok.Data;

@Data
public class GetBoardOne {
    private long boardId;
    private String title;
    private long writerId;
    private String contents;
    private int hits;
    private String createdAt;
    private String updatedAt;
    private String writerNm;
}
