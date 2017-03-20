package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.po.Visitors;
import com.mmt.tourism.pojo.po.VisitorsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitorsMapper {
    int countByExample(VisitorsExample example);

    int deleteByExample(VisitorsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Visitors record);

    int insertSelective(Visitors record);

    List<Visitors> selectByExample(VisitorsExample example);

    Visitors selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Visitors record, @Param("example") VisitorsExample example);

    int updateByExample(@Param("record") Visitors record, @Param("example") VisitorsExample example);

    int updateByPrimaryKeySelective(Visitors record);

    int updateByPrimaryKey(Visitors record);
}