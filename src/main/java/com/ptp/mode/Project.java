package com.ptp.mode;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
public class Project implements Serializable {
    @NotNull(message = "id不能为空", groups = {UpdateGroup.class})
    private Long id;

    @NotBlank(message = "工程名不能为空")
    private String projectName;

    private String descn;
    @NotBlank(message = "访问参数不能为空")
    private String accessParams;

    private String version;

    private String remark;

    private String globalVars;

    private Byte usedFlag;

    private Date createTime;

    private Long createUserId;

    private Date updateTime;

    private Long updateUserId;

    private static final long serialVersionUID = 1L;



}