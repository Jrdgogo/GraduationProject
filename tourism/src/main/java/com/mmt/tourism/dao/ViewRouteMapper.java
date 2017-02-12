package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.ViewRoute;
import com.mmt.tourism.pojo.ViewRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewRouteMapper {
    int countByExample(ViewRouteExample example);

    int deleteByExample(ViewRouteExample example);

    int deleteByPrimaryKey(String id);

    int insert(ViewRoute record);

    int insertSelective(ViewRoute record);

    List<ViewRoute> selectByExample(ViewRouteExample example);

    ViewRoute selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ViewRoute record, @Param("example") ViewRouteExample example);

    int updateByExample(@Param("record") ViewRoute record, @Param("example") ViewRouteExample example);

    int updateByPrimaryKeySelective(ViewRoute record);

    int updateByPrimaryKey(ViewRoute record);
}