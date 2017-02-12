package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.ViewSetMenu;
import com.mmt.tourism.pojo.ViewSetMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewSetMenuMapper {
    int countByExample(ViewSetMenuExample example);

    int deleteByExample(ViewSetMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(ViewSetMenu record);

    int insertSelective(ViewSetMenu record);

    List<ViewSetMenu> selectByExample(ViewSetMenuExample example);

    ViewSetMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ViewSetMenu record, @Param("example") ViewSetMenuExample example);

    int updateByExample(@Param("record") ViewSetMenu record, @Param("example") ViewSetMenuExample example);

    int updateByPrimaryKeySelective(ViewSetMenu record);

    int updateByPrimaryKey(ViewSetMenu record);
}