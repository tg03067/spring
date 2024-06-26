package com.green.boardver4.board.model;

import lombok.Data;

@Data
public class GetBoardList {
    private long boardId;
    private String title;
    private long writerId;
    private int hits;
    private String createdAt;
    private String updatedAt;
    private String writerNm;
}
