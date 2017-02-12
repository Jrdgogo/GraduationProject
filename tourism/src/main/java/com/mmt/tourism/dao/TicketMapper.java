package com.mmt.tourism.dao;

import com.mmt.tourism.pojo.Ticket;
import com.mmt.tourism.pojo.TicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    int countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(String id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example,@Param("date") String date);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example,@Param("date") String date);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}