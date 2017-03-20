package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.po.UserAccount;
import com.mmt.tourism.pojo.po.UserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountMapper {
    int countByExample(UserAccountExample example);

    int deleteByExample(UserAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    List<UserAccount> selectByExample(UserAccountExample example);

    UserAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}