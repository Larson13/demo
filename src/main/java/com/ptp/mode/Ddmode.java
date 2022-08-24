package com.ptp.mode;

import lombok.*;



import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Ddmode {
    @NotNull(message = "id不能为空" , groups = {UpdateGroup.class})
    Integer id;
    @NotBlank(message = "用户名不能为空哦")
    private String name;
    @NotBlank(message = "user用户名不能为空哦")
    private  String user;
    @Max(value = 100, message = "年龄不能超过100")
    @Min(value = 1, message = "年龄不能小于1")
    @Digits(integer =5,fraction=5,message = "value小于1")
    private  Double age;
    @Size(min=2, message="msg不能小于2")
    @Size (max=5, message="msg不能大于99")
    private String  msg;

}
