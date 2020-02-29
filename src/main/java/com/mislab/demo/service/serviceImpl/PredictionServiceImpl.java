package com.mislab.demo.service.serviceImpl;

import com.mislab.demo.dao.AdviceDao;
import com.mislab.demo.dao.PredictionDao;
import com.mislab.demo.domain.entity.Advice;
import com.mislab.demo.domain.entity.Prediction;
import com.mislab.demo.domain.po.AdvicePo;
import com.mislab.demo.domain.po.PredictionPo;
import com.mislab.demo.domain.po.PredictionSimplePo;
import com.mislab.demo.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2020/2/7 下午5:01
 */
@Service
public class PredictionServiceImpl implements PredictionService {

    @Resource
    private PredictionDao predictionDao;
    @Resource
    private AdviceDao adviceDao;

    @Override
    public PredictionPo selectPredictionById(Integer predictionId) {
        Prediction prediction = predictionDao.selectPredictionById(predictionId);
        if (prediction==null){
            return null;
        }else {
            PredictionPo predictionPo = new PredictionPo();
            List<AdvicePo> list = new ArrayList<>();
            list.add(adviceDao.selectAdviceById(prediction.getAdviceId()));
            predictionPo.setAdvice(list);
            predictionPo.setAge(prediction.getAge());
            predictionPo.setDiseaseProb(prediction.getDiseaseProb());
            predictionPo.setHeight(prediction.getHeight());
            predictionPo.setPredictTime(prediction.getPredictTime());
            predictionPo.setWeight(prediction.getWeight());
            predictionPo.setSex(prediction.getSex());
            System.out.println(prediction.getPredictTime());
            return predictionPo;
        }
    }

    @Override
    public List<PredictionSimplePo> selectSimPredictionByUserId(HttpServletRequest request) {
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        return predictionDao.selectSimPredictionByUserId(userId);
    }


    @Override
    public Integer countPredictionNumByTime() {
        return predictionDao.countPredictionNumByTime();
    }

    @Override
    public Integer countPredictionNumByUserId(HttpServletRequest request) {
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        return predictionDao.countPredictionNumByUserId(userId);
    }


}
