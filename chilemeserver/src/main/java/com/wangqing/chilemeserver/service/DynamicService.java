package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dto.DynamicDto;
import com.wangqing.chilemeserver.repository.DynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicService {
    @Autowired(required = false)
    DynamicMapper dynamicMapper;

    public List<DynamicDto> getDynamicList(Integer userId){
        return dynamicMapper.getDynamicList(userId);
    }
}
