package com.ptp.mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Duser {
    @NotNull(message = "id不能为空" , groups = {UpdateGroup.class})
    private  Integer id;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "password不能为空哦")
    private  String password;
    @Max(value = 100, message = "年龄不能超过100")
    @Min(value = 1, message = "年龄不能小于1")
    @NotNull(message = "age不能为空")
    private Integer age;
    private String address;

}
