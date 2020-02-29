package com.mislab.demo.controller;

import com.mislab.demo.domain.entity.Result;
import com.mislab.demo.service.AdviceService;
import com.mislab.demo.service.UserService;
import com.mislab.demo.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HanSiyue
 * @Date 2020/2/1 下午4:34
 */
@RestController
@RequestMapping("ManageSystem")
@Api("管理系统")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @PostMapping("addAdvice")
    @ApiOperation("增加建议")
    public Result addAdvice(String advice, Integer level) {
        try {
            if (adviceService.addAdvice(advice, level)){
                return ResultUtil.success();
            }else {
                return ResultUtil.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("deleteAdvice")
    @ApiOperation("删除建议")
    public Result deleteAdvice(Integer adviceId) {
        try {
            if (adviceService.deleteAdviceById(adviceId)){
                return ResultUtil.success();
            }else {
                return ResultUtil.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("updateAdvice")
    @ApiOperation("更新建议")
    public Result updateAdvice(Integer adviceId, String advice, Integer level) {
        try {
            if (adviceService.updateAdvice(adviceId, advice, level)){
                return ResultUtil.success();
            }else {
                return ResultUtil.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("selectAdvice")
    @ApiOperation("查询建议")
    public Result selectAdvice(Integer adviceId) {
        try {
            return ResultUtil.success(adviceService.selectAdviceById(adviceId));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("selectAllAdivice")
    @ApiOperation("查询全部建议")
    public Result selectAllAdvice() {
        try {
            return ResultUtil.success(adviceService.selectAllAdvice());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

}

