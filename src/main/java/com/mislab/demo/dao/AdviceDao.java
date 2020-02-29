package com.mislab.demo.dao;

import com.mislab.demo.domain.entity.Advice;
import com.mislab.demo.domain.po.AdvicePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/12/3 下午8:54
 */
@Repository
public interface AdviceDao {

    /**
     * 增加建议
     * @param advice 建议
     * @param level 等级
     * @return boolean
     */
    Boolean addAdvice(@Param("advice") String advice,@Param("level") Integer level);

    /**
     * 根据id查询建议
     * @param adviceId 建议Id
     * @return advicePo
     */
    AdvicePo selectAdviceById(@Param("adviceId") Integer adviceId);

    /**
     * 修改建议
     * @param adviceId 建议Id
     * @param advice 建议
     * @param level 等级
     * @return boolean
     */
    Boolean updateAdvice(@Param("adviceId") Integer adviceId,@Param("advice") String advice,@Param("level") Integer level);

    /**
     * 根据id删除建议
     * @param adviceId 建议Id
     * @return boolean
     */
    Boolean deleteAdviceById(@Param("adviceId") Integer adviceId);

    /**
     * 查询所有建议
     * @return advice
     */
    List<Advice> selectAllAdvice();


}
