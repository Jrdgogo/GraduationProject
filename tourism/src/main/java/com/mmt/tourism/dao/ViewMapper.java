package com.mmt.tourism.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mmt.tourism.pojo.po.View;
import com.mmt.tourism.pojo.po.ViewExample;

public interface ViewMapper {
    int countByExample(ViewExample example);

    int deleteByExample(ViewExample example);

    int deleteByPrimaryKey(String id);

    int insert(View record);

    int insertSelective(View record);

    List<View> selectByExampleWithBLOBs(ViewExample example);

    List<View> selectByExample(ViewExample example);

    View selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") View record, @Param("example") ViewExample example);

    int updateByExampleWithBLOBs(@Param("record") View record, @Param("example") ViewExample example);

    int updateByExample(@Param("record") View record, @Param("example") ViewExample example);

    int updateByPrimaryKeySelective(View record);

    int updateByPrimaryKeyWithBLOBs(View record);

    int updateByPrimaryKey(View record);
}