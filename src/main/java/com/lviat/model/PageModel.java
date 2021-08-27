package com.lviat.model;

import java.util.List;

/**
 * @author 12401
 */
public class PageModel {
    private int pageSize = 6;//每页条数
    private int recordCount;//总记录数
    private int pageNo;//当前页数
    private int pageCount;//总页数

    private String likeValue;//查询条件
    private List<?> recordList;//当前页数

    public PageModel(){

    }

    public PageModel(int pageSize,int recordCount, int pageNo,int pageCount,String likeValue,List<?> recordList) {
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        this.pageNo = pageNo;
        this.pageCount = pageCount;
        this.likeValue = likeValue;
        this.recordList = recordList;

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() { return recordCount; }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageCount() {
        return this.recordCount%this.pageSize==0?this.recordCount/this.pageSize:this.recordCount/this.pageSize+1;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(String likeValue) {
        this.likeValue = likeValue;
    }

    public List<?> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<?> recordList) {
        this.recordList = recordList;
    }
}
