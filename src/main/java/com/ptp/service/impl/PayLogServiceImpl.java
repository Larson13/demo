package com.ptp.service.impl;

import com.ptp.dao.PayLogMapper;
import com.ptp.mode.PayLog;
import com.ptp.service.PayLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("payLogService")
@Slf4j
public class PayLogServiceImpl implements PayLogService {
    @Autowired
    private PayLogMapper payLogMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return payLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PayLog record) {
        return payLogMapper.insert(record);
    }

    @Override
    public int insertSelective(PayLog record) {
        return payLogMapper.insertSelective(record);
    }

    @Override
    public PayLog selectByPrimaryKey(Integer id) {
        return payLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PayLog record) {
        return payLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PayLog record) {
        return payLogMapper.updateByPrimaryKey(record);
    }
}
