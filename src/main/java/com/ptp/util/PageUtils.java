package com.ptp.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageUtils<T> implements Serializable {

	private static final long serialVersionUID = 732182544400900535L;
	//当前页
	private int currentPage;
	//页面大小
	private int pageSize;
	// 分页开关，默认打开
	private boolean flag = true;
	// 存储查询结果
	private List<T> list;

	private int totalNums;

	private String keyword;

	private Long nowUserId;

	private String user_name;

	private Long parentId;

	private Integer isAdmin;


}
