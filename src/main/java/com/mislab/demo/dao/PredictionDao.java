package com.mislab.demo.dao;

import com.mislab.demo.domain.entity.Prediction;
import com.mislab.demo.domain.po.PredictionPo;
import com.mislab.demo.domain.po.PredictionSimplePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2020/2/6 下午3:59
 */
@Repository
public interface PredictionDao {

    /**
     * 通过ID查询详细预测结果
     * @param predictionId 结果ID
     * @return 预测结果
     */
    Prediction selectPredictionById(@Param("predictionId") Integer predictionId);

    /**
     * 通过用户ID查询简单预测结果
     * @param userId 用户ID
     * @return 简单预测结果
     */
    List<PredictionSimplePo> selectSimPredictionByUserId(@Param("userId") Integer userId);

    /**
     * 通过时间计算预测次数
     * @return 预测数量
     */
    Integer countPredictionNumByTime();

    /**
     * 通过用户ID计算预测次数
     * @param userId 用户ID
     * @return 预测数量
     */
    Integer countPredictionNumByUserId(@Param("userId") Integer userId);

}
