package com.sipingsoft.core.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author HeChunXiao
 * @since 2018-12-13 上午 9:38
 */
public class PageResponse<T> implements Serializable {

    //总页数
    private Integer tatol;

    //总条目数
    private Integer tatalCount;

    //返回的数据
    private List<T> records;

    //当前页
    private Integer page;

    public PageResponse(Integer tatol, Integer tatalCount, List<T> records, Integer page) {
        this.tatol = tatol;
        this.tatalCount = tatalCount;
        this.records = records;
        this.page = page;
    }

    public Integer getTatol() {
        return tatol;
    }

    public void setTatol(Integer tatol) {
        this.tatol = tatol;
    }

    public Integer getTatalCount() {
        return tatalCount;
    }

    public void setTatalCount(Integer tatalCount) {
        this.tatalCount = tatalCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     计算总页数
     */
    public static<T> PageResponse<T> getPageResponse(List<T> list,Integer count,Integer page,Integer rows){
        //计算页数
        Integer total = (count%rows)==0?(count/rows):(count/rows+1);
        return new PageResponse<>(total,count,list,page);
    }
}
