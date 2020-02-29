package com.mislab.demo.service.serviceImpl;

import com.mislab.demo.dao.AdviceDao;
import com.mislab.demo.domain.entity.Advice;
import com.mislab.demo.domain.po.AdvicePo;
import com.mislab.demo.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/12/3 下午9:37
 */
@Service
public class AdviceServiceImpl implements AdviceService {

    @Resource
    private AdviceDao adviceDao;

    @Override
    public Boolean addAdvice(String advice, Integer level) {
        if (advice==null||level==null){
            return false;
        }else {
            return adviceDao.addAdvice(advice, level);
        }
    }

    @Override
    public AdvicePo selectAdviceById(Integer adviceId) {
        if (adviceId==null){
            return null;
        }else {
            return adviceDao.selectAdviceById(adviceId);
        }
    }

    @Override
    public List<Advice> selectAllAdvice() {
        return adviceDao.selectAllAdvice();
    }

    @Override
    public Boolean updateAdvice(Integer adviceId, String advice, Integer level) {
        if (advice==null||level==null||adviceId==null||selectAdviceById(adviceId)==null){
            return false;
        }else {
            return adviceDao.updateAdvice(adviceId, advice, level);
        }
    }

    @Override
    public Boolean deleteAdviceById(Integer adviceId) {
        if (adviceId==null){
            return false;
        }else {
            return adviceDao.deleteAdviceById(adviceId);
        }
    }
}
