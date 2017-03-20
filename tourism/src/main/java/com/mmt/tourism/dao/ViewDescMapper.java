package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.po.ViewDesc;
import com.mmt.tourism.pojo.po.ViewDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewDescMapper {
    int countByExample(ViewDescExample example);

    int deleteByExample(ViewDescExample example);

    int deleteByPrimaryKey(String id);

    int insert(ViewDesc record);

    int insertSelective(ViewDesc record);

    List<ViewDesc> selectByExampleWithBLOBs(ViewDescExample example);

    List<ViewDesc> selectByExample(ViewDescExample example);

    ViewDesc selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ViewDesc record, @Param("example") ViewDescExample example);

    int updateByExampleWithBLOBs(@Param("record") ViewDesc record, @Param("example") ViewDescExample example);

    int updateByExample(@Param("record") ViewDesc record, @Param("example") ViewDescExample example);

    int updateByPrimaryKeySelective(ViewDesc record);

    int updateByPrimaryKeyWithBLOBs(ViewDesc record);

    int updateByPrimaryKey(ViewDesc record);
}