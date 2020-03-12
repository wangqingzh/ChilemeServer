package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.CampusEvaluate;
import com.wangqing.chilemeserver.object.dbo.Post;
import com.wangqing.chilemeserver.object.dto.CESel;
import com.wangqing.chilemeserver.object.dto.EvaluateBrowserDto;
import com.wangqing.chilemeserver.object.dto.EvaluateDetailDto;
import com.wangqing.chilemeserver.object.dto.EvaluatePostDto;
import com.wangqing.chilemeserver.repository.CampusEvaluateMapper;
import com.wangqing.chilemeserver.repository.CampusEvaluateRepository;
import com.wangqing.chilemeserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusEvaluateService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CampusEvaluateRepository campusEvaluateRepository;
    @Autowired(required = false)
    CampusEvaluateMapper campusEvaluateMapper;

    /**
     * 添加校园餐饮点评
     * @param evaluate
     * @return
     */
    public Integer addEvaluate(EvaluatePostDto evaluate){
        Post post = new Post();
        post.setPostType(0);
        post.setHeadline(evaluate.getHeadline());
        post.setUserId(evaluate.getPostUserId());

        post = postRepository.saveAndFlush(post);

        CampusEvaluate campusEvaluate = new CampusEvaluate();
        campusEvaluate.setContent(evaluate.getContent());
        campusEvaluate.setDish(evaluate.getDish());
        campusEvaluate.setEvaluateScore(evaluate.getEvaluateScore());
        campusEvaluate.setStoreName(evaluate.getStoreName());
        campusEvaluate.setHallId(evaluate.getHallId());
        campusEvaluate.setPostId(post.getPostId());
        campusEvaluateRepository.saveAndFlush(campusEvaluate);
        return post.getPostId();
    }

    /**
     * 根据参数获取 餐饮评价
     * @param userId　访问人userId
     * @param hallId  食堂 hallId
     * @return
     */
    public List<EvaluateBrowserDto> getEvaluate(Integer userId, Integer hallId){
        return campusEvaluateMapper.getEvaluate(userId, hallId);
    }

    public EvaluateDetailDto getEvaluateDetail(CESel ceSel){
        return campusEvaluateMapper.getEvaluateDetailByCESel(ceSel);
    }

}
