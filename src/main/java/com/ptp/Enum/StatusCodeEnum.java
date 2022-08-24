package com.ptp.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCodeEnum {
    SUCCESS("200","succes"),FAILE("400","param fail"),EXCEPTION("500","系统错误");
   private String code;
   private String msg;


}
