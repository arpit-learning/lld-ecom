package dev.arpit.ecom.dtos;

import lombok.Data;

@Data
public class ResponseDto<T> {
  private T data;
  private MetaDataDto meta;
}
