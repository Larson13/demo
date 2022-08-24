package com.ptp.mode;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    private Long id;
    @NotBlank(message="姓名不能空")
    private String userName;
    @NotBlank(message="登录名不能空")
    private String loginName;
    @NotBlank(message="密码不能空")
    private String password;

    private String phone;

    private String email;

    private Byte status;

    private Byte usedFlag;

    private Date createTime;

    private Long createUserId;

    private static final long serialVersionUID = 1L;


}