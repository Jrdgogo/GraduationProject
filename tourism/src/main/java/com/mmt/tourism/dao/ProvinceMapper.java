package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.Province;
import com.mmt.tourism.pojo.ProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceMapper {
    int countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(String namecode);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(String namecode);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}