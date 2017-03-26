package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.po.Eat;
import com.mmt.tourism.pojo.po.EatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EatMapper {
    int countByExample(EatExample example);

    int deleteByExample(EatExample example);

    int deleteByPrimaryKey(String id);

    int insert(Eat record);

    int insertSelective(Eat record);

    List<Eat> selectByExampleWithBLOBs(EatExample example);

    List<Eat> selectByExample(EatExample example);

    Eat selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Eat record, @Param("example") EatExample example);

    int updateByExampleWithBLOBs(@Param("record") Eat record, @Param("example") EatExample example);

    int updateByExample(@Param("record") Eat record, @Param("example") EatExample example);

    int updateByPrimaryKeySelective(Eat record);

    int updateByPrimaryKeyWithBLOBs(Eat record);

    int updateByPrimaryKey(Eat record);
}