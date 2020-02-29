package com.mislab.demo.controller;

import com.mislab.demo.domain.entity.Result;
import com.mislab.demo.service.PredictionService;
import com.mislab.demo.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HanSiyue
 * @Date 2020/2/8 下午3:06
 */
@RestController
@RequestMapping("PredictionSystem")
@Api("预测系统")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping("selectPredictionById")
    @ApiOperation("通过ID查询详细预测结果")
    public Result selectPredictionById(Integer predictionId) {
        try {
            return ResultUtil.success(predictionService.selectPredictionById(predictionId));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("selectSimPredictionByUserId")
    @ApiOperation("通过用户ID查询全部简单预测结果")
    public Result selectSimPredictionByUserId(HttpServletRequest request) {
        try {
            return ResultUtil.success(predictionService.selectSimPredictionByUserId(request));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("countPredictionNumByTime")
    @ApiOperation("通过时间计算预测次数")
    public Result countPredictionNumByTime(){
        try {
            return ResultUtil.success(predictionService.countPredictionNumByTime());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("countPredctionNumByUserId")
    @ApiOperation("通过用户ID计算预测次数")
    public Result countPredctionNumByUserId(HttpServletRequest request){
        try {
            return ResultUtil.success(predictionService.countPredictionNumByUserId(request));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}
