package com.mmt.tourism.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mmt.tourism.pojo.po.VisitDate;
import com.mmt.tourism.pojo.po.VisitDateExample;

public interface VisitDateMapper {
    int countByExample(VisitDateExample example);

    int deleteByExample(VisitDateExample example);

    int deleteByPrimaryKey(String id);

    int insert(VisitDate record);

    int insertSelective(VisitDate record);

    List<VisitDate> selectByExample(VisitDateExample example);

    VisitDate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VisitDate record, @Param("example") VisitDateExample example);

    int updateByExample(@Param("record") VisitDate record, @Param("example") VisitDateExample example);

    int updateByPrimaryKeySelective(VisitDate record);

    int updateByPrimaryKey(VisitDate record);
}