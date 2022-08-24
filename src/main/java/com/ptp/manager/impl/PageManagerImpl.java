package com.ptp.manager.impl;

import com.ptp.dao.PageMapper;
import com.ptp.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Slf4j
public class PageManagerImpl {

    protected <T> PageUtils<T> getPageJson(PageMapper pageMapper, PageUtils<T> page) {
        String keyword = page.getKeyword();
        if (!StringUtils.isBlank(keyword)) {
            page.setKeyword("%" + keyword + "%");
        }
        page.setCurrentPage(page.getCurrentPage() * page.getPageSize());
        List<T> list = pageMapper.listAllByPage(page);
        page.setList(list);
        log.info("分页查到的：{}", list);
        int count = pageMapper.getCount();
        page.setTotalNums(count);
        log.info("分页查到的：{}", page);
        if (!StringUtils.isBlank(keyword)) {
            page.setKeyword(keyword );
        }
        return page;

    }
}
