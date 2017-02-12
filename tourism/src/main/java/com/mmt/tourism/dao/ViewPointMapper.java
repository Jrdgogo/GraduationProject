package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.ViewPoint;
import com.mmt.tourism.pojo.ViewPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewPointMapper {
    int countByExample(ViewPointExample example);

    int deleteByExample(ViewPointExample example);

    int deleteByPrimaryKey(String id);

    int insert(ViewPoint record);

    int insertSelective(ViewPoint record);

    List<ViewPoint> selectByExampleWithBLOBs(ViewPointExample example);

    List<ViewPoint> selectByExample(ViewPointExample example);

    ViewPoint selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ViewPoint record, @Param("example") ViewPointExample example);

    int updateByExampleWithBLOBs(@Param("record") ViewPoint record, @Param("example") ViewPointExample example);

    int updateByExample(@Param("record") ViewPoint record, @Param("example") ViewPointExample example);

    int updateByPrimaryKeySelective(ViewPoint record);

    int updateByPrimaryKeyWithBLOBs(ViewPoint record);

    int updateByPrimaryKey(ViewPoint record);
}