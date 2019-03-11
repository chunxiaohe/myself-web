package com.cc.core.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author HeChunXiao
 * @since 2018-12-13 上午 9:38
 */
public class PageResponse<T> implements Serializable {

    //总页数
    private Integer total;

    //总条目数
    private Integer totalCount;

    //返回的数据
    private List<T> records;

    //当前页
    private Integer page;

    public PageResponse(Integer total, Integer totalCount, List<T> records, Integer page) {
        this.total = total;
        this.totalCount = totalCount;
        this.records = records;
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer tatol) {
        this.total = tatol;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer tatalCount) {
        this.totalCount = tatalCount;
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
    public static<T> PageResponse<T> getPageResponse(List<T> list,Integer totalCount,Integer page,Integer rows){
        //计算页数
        Integer total = (totalCount%rows)==0?(totalCount/rows):(totalCount/rows+1);
        return new PageResponse<>(total,totalCount,list,page);
    }
}
