package org.iscas.web.dto;

import org.springframework.http.HttpStatus;

/**
 * 一般性的返回JSON体格式
 * @author suemi
 */
public class ResponseDto {

  protected int status;

  protected String message;

  public static ResponseDto OK = new ResponseDto(HttpStatus.OK,null);

  public ResponseDto(){}

  public ResponseDto(int code, String message){
    this.status = code;
    this.message = message;
  }

  public ResponseDto(HttpStatus httpStatus, String message){ this(httpStatus.value(),message); }

  public ResponseDto(String message){ this(HttpStatus.OK,message); }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
