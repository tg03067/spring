package com.green.boardver4.board.model;

import lombok.Data;

@Data
public class PutBoard {
    private long boardId;
    private String title;
    private String contents;
}
