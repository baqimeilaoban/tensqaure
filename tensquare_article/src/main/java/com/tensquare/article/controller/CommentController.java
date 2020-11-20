package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",commentService.findAll());
    }

    /**
     * 根据userid删除评论
     * @param id
     * @return
     */
    @RequestMapping(value = "/{userid}",method = RequestMethod.DELETE)
    public Result deleteByArticleid(@PathVariable("userid")String id){
        commentService.deleteByArticleid(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据文章ID查询评论
     * @param articleid
     * @return
     */
    @RequestMapping(value = "/article/{articleid}")
    public Result findByArticleid(@PathVariable String articleid){
        return new Result(true,StatusCode.OK,"查询成功",commentService.findByArticleid(articleid));
    }

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment){
        comment.setPublishdate(new Date());
        commentService.add(comment);
        return new Result(true, StatusCode.OK,"保存成功");
    }
}
