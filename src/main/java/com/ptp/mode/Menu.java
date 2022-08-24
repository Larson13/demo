package com.ptp.mode;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {
    private Long id;

    private String menuName;

    private String aliasName;

    private Byte level;

    private Long parentId;

    private Short serial;

    private String locationUrl;

    private Byte status;

    private Byte usedFlag;

    private Date createTime;

    private Long createUserId;

    private List<Menu> subMenuList;
    private static final long serialVersionUID = 1L;


}