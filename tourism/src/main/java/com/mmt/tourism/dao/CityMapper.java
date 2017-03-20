package com.mmt.tourism.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mmt.tourism.pojo.po.City;
import com.mmt.tourism.pojo.po.CityExample;

public interface CityMapper {
    int countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(String code);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}