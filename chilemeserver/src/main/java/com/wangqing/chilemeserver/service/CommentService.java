package com.wangqing.chilemeserver.service;

import com.wangqing.chilemeserver.object.dbo.Comment;
import com.wangqing.chilemeserver.object.dto.CommentBrowserDto;
import com.wangqing.chilemeserver.object.dto.CommentPostDto;
import com.wangqing.chilemeserver.repository.CommentMapper;
import com.wangqing.chilemeserver.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;


    public void addComment(CommentPostDto commentPostDto){
        Comment comment = new Comment();
        comment.setPostId(commentPostDto.getPostId());
        comment.setContent(commentPostDto.getContent());
        comment.setFromUid(commentPostDto.getFromUid());
        comment.setToUid(commentPostDto.getToUid());
        commentRepository.saveAndFlush(comment);
    }

    public List<CommentBrowserDto> getCommentByPostIdAndUserId(Integer postId, Integer userId){
        return commentMapper.getCommentByPostIdAndUserId(postId, userId);
    }

}
