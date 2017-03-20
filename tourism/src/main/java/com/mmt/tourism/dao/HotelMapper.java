package com.mmt.tourism.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mmt.tourism.pojo.po.Hotel;
import com.mmt.tourism.pojo.po.HotelExample;

public interface HotelMapper {
    int countByExample(HotelExample example);

    int deleteByExample(HotelExample example);

    int deleteByPrimaryKey(String id);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    List<Hotel> selectByExampleWithBLOBs(HotelExample example);

    List<Hotel> selectByExample(HotelExample example);

    Hotel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByExampleWithBLOBs(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKeyWithBLOBs(Hotel record);

    int updateByPrimaryKey(Hotel record);
}