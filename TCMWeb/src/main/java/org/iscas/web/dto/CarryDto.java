package org.iscas.web.dto;
import org.springframework.http.HttpStatus;

/**
 * 携带泛化对象的Dto,方便返回一些不想设置独立Dto对象的返回
 * @param <E> 返回的数据对象
 */
public class CarryDto<E> extends ResponseDto{

  public E data;

  public CarryDto(int code, String message, E data){
    super(code, message);
    this.data = data;
  }

  public CarryDto(HttpStatus httpStatus, String message, E data) {
    super(httpStatus, message);
    this.data = data;
  }

  public CarryDto(String message, E data){ this(HttpStatus.OK,message,data); }

  public CarryDto(E data){ this(HttpStatus.OK,null,data); }

  public static <E> CarryDto of(E data){
    return new CarryDto(data);
  }

  public E getData() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }
}
