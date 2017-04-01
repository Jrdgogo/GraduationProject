package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoMapper {
    int countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExampleWithBLOBs(PhotoExample example);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExampleWithBLOBs(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKeyWithBLOBs(Photo record);

    int updateByPrimaryKey(Photo record);
}