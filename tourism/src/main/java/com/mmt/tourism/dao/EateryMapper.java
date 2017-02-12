package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.Eatery;
import com.mmt.tourism.pojo.EateryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EateryMapper {
    int countByExample(EateryExample example);

    int deleteByExample(EateryExample example);

    int deleteByPrimaryKey(String id);

    int insert(Eatery record);

    int insertSelective(Eatery record);

    List<Eatery> selectByExampleWithBLOBs(EateryExample example);

    List<Eatery> selectByExample(EateryExample example);

    Eatery selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Eatery record, @Param("example") EateryExample example);

    int updateByExampleWithBLOBs(@Param("record") Eatery record, @Param("example") EateryExample example);

    int updateByExample(@Param("record") Eatery record, @Param("example") EateryExample example);

    int updateByPrimaryKeySelective(Eatery record);

    int updateByPrimaryKeyWithBLOBs(Eatery record);

    int updateByPrimaryKey(Eatery record);
}