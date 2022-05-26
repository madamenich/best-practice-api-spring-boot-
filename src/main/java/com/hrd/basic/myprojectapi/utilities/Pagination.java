package com.hrd.basic.myprojectapi.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
public class Pagination {
    private int page;
    private int limit;

    private int nextPage;
    private int previousPage;

    private int totalCount;
    private int totalPages;

    private int pagesToShow;
    private int startPage;
    private int endPage;

    @JsonIgnore
    private int offset;

    public Pagination(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public Pagination() {
        this(1, 10, 0, 0, 5);
    }
    public Pagination(int page, int limit, int totalCount, int totalPages, int pagesToShow) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.pagesToShow = pagesToShow;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int currentPage) {
        this.page = Math.max(currentPage, 1);
    }

    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.totalCount / limit);
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getOffset() {
        return (this.page - 1) * this.limit;
    }

    public int getNextPage() {
        return page >= getTotalPages() ? getTotalPages() : page + 1;
    }
    public int getPreviousPage() {
        return (page <= 1) ? 1 : page - 1;
    }

    public int getStartPage() {
        return startPage;
    }
    public int getEndPage() {
        return endPage;
    }

    public int getPagesToShow() {
        return pagesToShow;
    }
    public void setPagesToShow(int pagesToShow) {
        this.pagesToShow = pagesToShow;
    }

    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.setStartPageEndPage(getTotalPages());
    }

    private void setStartPageEndPage(int totalPages){
        int halfPagesToShow = pagesToShow / 2;

        if (totalPages <= pagesToShow) {
            startPage = 1;
            endPage = totalPages;

        } else if (page - halfPagesToShow <= 0) {
            startPage = 1;
            endPage = pagesToShow;

        } else if (page + halfPagesToShow == totalPages) {
            startPage = page - halfPagesToShow;
            endPage = totalPages;

        } else if (page + halfPagesToShow > totalPages) {
            startPage = totalPages - pagesToShow + 1;
            endPage = totalPages;

        } else {
            startPage = page - halfPagesToShow;
            endPage = page + halfPagesToShow;
        }
    }

    @Override
    public String toString() {
        return "Paging [page=" + page + ", limit=" + limit + ", totalCount=" + totalCount + ", totalPages=" + totalPages
                + ", nextPage=" + nextPage + ", previousPage=" + previousPage + ", offset=" + offset + "]";
    }

}
