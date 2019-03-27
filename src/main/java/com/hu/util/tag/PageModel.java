package com.hu.util.tag;

import com.hu.util.HrmConstants;

/**
 * 分页实体
 */
public class PageModel {

    /** 分页总数据条数 */
    private Integer recordCount;

    /** 当前页数 */
    private Integer pageIndex;

    /** 每页分多少条数据 */
    private Integer pageSize = HrmConstants.PAGE_DEFAULT_SIZE = 4;

    /** 总页数 */
    private Integer totalSize;

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getPageIndex() {
        this.pageIndex = this.pageIndex <=0?1:this.pageIndex;
        this.pageIndex = this.pageIndex >= this.getTotalSize()?this.getTotalSize():this.pageIndex;
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        this.pageSize = this.pageSize <= HrmConstants.PAGE_DEFAULT_SIZE?HrmConstants.PAGE_DEFAULT_SIZE:this.pageSize;
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        if (this.getRecordCount() <= 0) {
            totalSize = 0;
        } else {
            totalSize = (this.getRecordCount()-1)/this.getPageSize() +1;
        }
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getFirstLimitParam() {
        return (this.getPageIndex()-1)*this.getPageSize();
    }
}
