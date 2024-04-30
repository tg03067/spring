package com.green.boardver4.comment.model;

import com.green.boardver4.common.model.Paging;
import lombok.*;
import org.springframework.web.bind.annotation.BindParam;

@Getter
public class CommentPaging extends Paging {
    private long boardId;

    public CommentPaging(Integer page, Integer size,long boardId) {
        super(page, size);
        this.boardId = boardId;
    }
}