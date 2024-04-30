package com.green.boardver4.board.model;

import com.green.boardver4.comment.model.GetCommentRes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetBoardOne {
    private long boardId ;
    private String title ;
    private long writerId ;
    private String contents ;
    private int hits ;
    private String createdAt ;
    private String updatedAt ;
    private String writerNm ;
    private int totalCommentPage ;
    private List<GetCommentRes> comments ;
}
