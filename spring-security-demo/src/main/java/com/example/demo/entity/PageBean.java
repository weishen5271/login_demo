package com.example.demo.entity;

/**
 * <p>类描述：。</p>
 *
 * @author 沈伟 [shenwei]。
 * @version v1.0.0.1。
 * @since JDK1.8。
 * <p>创建日期：2020/9/25 0025 14:22。</p>
 */

public class PageBean {

    private Integer currentPage;
    protected Integer startIndex;
    protected Integer pageSize=5;
    private Integer totalCount;
    private Integer totalPage;
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        this.startIndex=(this.currentPage-1)*this.pageSize;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //计算总页数
        this.totalPage=(int)Math.ceil((this.totalCount*1.0/this.pageSize));
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

}
