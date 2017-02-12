package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.HotelRoom;
import com.mmt.tourism.pojo.HotelRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelRoomMapper {
    int countByExample(HotelRoomExample example);

    int deleteByExample(HotelRoomExample example);

    int deleteByPrimaryKey(String id);

    int insert(HotelRoom record);

    int insertSelective(HotelRoom record);

    List<HotelRoom> selectByExampleWithBLOBs(HotelRoomExample example);

    List<HotelRoom> selectByExample(HotelRoomExample example);

    HotelRoom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HotelRoom record, @Param("example") HotelRoomExample example);

    int updateByExampleWithBLOBs(@Param("record") HotelRoom record, @Param("example") HotelRoomExample example);

    int updateByExample(@Param("record") HotelRoom record, @Param("example") HotelRoomExample example);

    int updateByPrimaryKeySelective(HotelRoom record);

    int updateByPrimaryKeyWithBLOBs(HotelRoom record);

    int updateByPrimaryKey(HotelRoom record);
}