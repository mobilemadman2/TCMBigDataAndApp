package org.iscas.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.boot.jaxb.hbm.spi.PluralAttributeInfoPrimitiveArrayAdapter;

@Entity
@Table
public class BookProof extends IdEntity {
  @NotNull
  private String book_name;
  //书籍名字
  
  //书籍内容
  @Column(columnDefinition = "TEXT")
  private String book_content;
  
  //原始版本书籍
  private String origin;
  
  //修改之后的版本
  private String modify;
  
  //作者名字
  private String author_name;
  
  //朝代
  private String dynasty;
  
  //书籍大小
  private String book_size; 
  
  private String time_string;


public String getTime_string() {
	return time_string;
}

public void setTime_string(String time_string) {
	this.time_string = time_string;
}

public String getBook_size() {
	return book_size;
}

public void setBook_size(String book_size) {
	this.book_size = book_size;
}

public String getOrigin() {
	return origin;
}

public String getAuthor_name() {
	return author_name;
}

public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}

public String getDynasty() {
	return dynasty;
}

public void setDynasty(String dynasty) {
	this.dynasty = dynasty;
}

public void setOrigin(String origin) {
	this.origin = origin;
}

public String getModify() {
	return modify;
}

public void setModify(String modify) {
	this.modify = modify;
}

public String getBookName() {
	return book_name;
}

public void setBookName(String bookname) {
	this.book_name = bookname;
}

public String getContent() {
	return book_content;
}

public void setContent(String content) {
	this.book_content = content;
}

}
