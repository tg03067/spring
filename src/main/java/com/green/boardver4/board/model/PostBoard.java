package com.green.boardver4.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PostBoard {
    @JsonIgnore
    private long boardId;
    private String title;
    private String contents;
    private long writerId;
}
