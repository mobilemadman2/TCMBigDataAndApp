package org.iscas.web.dto;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.iscas.web.dto.ResponseDto;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

/**
 * 为分页使用的Dto对象
 * @param <E>
 * @author suemi
 */
public class PageDto<E> extends ResponseDto {

  public PageDto(){
    super(HttpStatus.OK,null);
  }


  public int page; // 当前页数

  public int pageSize; // 每页的大小

  public int totalPages; // 总页数

  public long totalSize; // 总元素个数

  public List<E> entries; // 具体元素集合
  

  public static <E> PageDto<E> of(Page<E> page) {
    PageDto<E> dto = new PageDto<E>();
    dto.page = page.getNumber();
    dto.pageSize = page.getSize();
    dto.totalPages = page.getTotalPages();
    dto.totalSize = page.getTotalElements();
    dto.entries = page.getContent();
    return dto;
  }
  public static <E> PageDto<E> ofList(List<E> data,int total,int pageNumber,int perSize) {
    PageDto<E> dto = new PageDto<E>();
    dto.page = pageNumber;
    dto.pageSize = perSize;
    dto.totalPages = (total-1)/perSize+1;
    dto.totalSize = total;
    
    List<E> newData = new ArrayList<>();
    for(int i=(pageNumber-1)*perSize;i<data.size()&&i<pageNumber*perSize;i++){
    	newData.add(data.get(i));
    }
    dto.entries = newData;
    return dto;
  }
  
  public static <E> PageDto<E> ofPagedList(List<E> data,int total,int pageNumber,int perSize) {
	    PageDto<E> dto = new PageDto<E>();
	    dto.page = pageNumber;
	    dto.pageSize = perSize;
	    dto.totalPages = (total-1)/perSize+1;
	    dto.totalSize = total;
	    
	    List<E> newData = new ArrayList<>();
	    for(int i=0;i<data.size();i++){
	    	newData.add(data.get(i));
	    }
	    dto.entries = newData;
	    return dto;
	  }
  public static <E, F> PageDto<E> of(Page<F> page, Function<F, E> mapper) {
    PageDto<E> dto = new PageDto<E>();
    dto.page = page.getNumber();
    dto.pageSize = page.getSize();
    dto.totalPages = page.getTotalPages();
    dto.totalSize = page.getTotalElements();
    dto.entries = page.getContent().stream().map(mapper)
            .collect(toList());
    return dto;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public long getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(long totalSize) {
    this.totalSize = totalSize;
  }

  public List<E> getEntries() {
    return entries;
  }

  public void setEntries(List<E> entries) {
    this.entries = entries;
  }
}
