package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.UserExtr;
import com.mmt.tourism.pojo.UserExtrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExtrMapper {
    int countByExample(UserExtrExample example);

    int deleteByExample(UserExtrExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserExtr record);

    int insertSelective(UserExtr record);

    List<UserExtr> selectByExample(UserExtrExample example);

    UserExtr selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserExtr record, @Param("example") UserExtrExample example);

    int updateByExample(@Param("record") UserExtr record, @Param("example") UserExtrExample example);

    int updateByPrimaryKeySelective(UserExtr record);

    int updateByPrimaryKey(UserExtr record);
}