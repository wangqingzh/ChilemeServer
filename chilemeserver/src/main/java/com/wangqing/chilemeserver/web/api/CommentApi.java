package com.wangqing.chilemeserver.web.api;

import com.wangqing.chilemeserver.object.ao.CommonResult;
import com.wangqing.chilemeserver.object.dbo.Comment;
import com.wangqing.chilemeserver.object.dto.CommentPostDto;
import com.wangqing.chilemeserver.repository.CommentRepository;
import com.wangqing.chilemeserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentApi {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    /**
     * 根据 帖子id 获取所有评论
     * @param postId
     * @return
     */
    @GetMapping("/{postId}")
    public HttpEntity<?> getCommentByPostId(@PathVariable("postId") Integer postId){
        List<Comment> comments = commentRepository.findByPostIdAndStatus(postId, true);
        return  new ResponseEntity<>(CommonResult.success(comments), HttpStatus.OK);
    }

    /**
     * 增加一条评论
     * @return
     */
    @PostMapping
    public HttpEntity<?> addComment(@RequestBody CommentPostDto commentPostDto){
        commentService.addComment(commentPostDto);
        return new ResponseEntity<>(CommonResult.success(), HttpStatus.OK);
    }
}
