package com.mislab.demo.service;

import com.mislab.demo.domain.entity.Prediction;
import com.mislab.demo.domain.po.PredictionPo;
import com.mislab.demo.domain.po.PredictionSimplePo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2020/2/7 下午5:00
 */
@Service
public interface PredictionService {
    /**
     * 通过ID查询详细预测结果
     * @param predictionId 结果ID
     * @return 预测结果
     */
    PredictionPo selectPredictionById(@Param("predictionId") Integer predictionId);

    /**
     * 通过用户ID查询简单预测结果
     * @param request request
     * @return 简单预测结果
     */
    List<PredictionSimplePo> selectSimPredictionByUserId(HttpServletRequest request);

    /**
     * 计算预测次数
     * @return 预测数量
     */
    Integer countPredictionNumByTime();

    /**
     * 通过用户ID计算预测次数
     * @return 预测数量
     */
    Integer countPredictionNumByUserId(HttpServletRequest request);
}
