package com.green.boardver4.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class Paging {
    private int page ;
    private int size ;

    @JsonIgnore
    @ConstructorProperties({"page", "size"})
    public Paging(Integer page, Integer size){
        this.page = page == null || page == 0 ? 1 : page;
        this.size = size == null || size == 0 ? 10 : size;
        this.startIdx = this.page - 1 >= 0 ? (this.page - 1) * this.size : 0 ;
    }

    @JsonIgnore
    private int startIdx;
}
