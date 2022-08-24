package com.ptp.dao;

import com.ptp.util.PageUtils;

import java.util.List;

public interface PageMapper {
    <T> List<T> listAllByPage(PageUtils<T> page);

    int getCount();
}
