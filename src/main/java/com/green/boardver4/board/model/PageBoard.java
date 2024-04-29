package com.green.boardver4.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class PageBoard {
    private int page ;
    private int size ;

    @JsonIgnore
    @ConstructorProperties({"page", "size"})
    public PageBoard(Integer page, Integer size){
        this.page = page == null ? 1 : page;
        this.size = size == null ? 10 : size;
        this.startIdx = (this.page - 1) * this.size;
    }

    @JsonIgnore
    private int startIdx;
}
