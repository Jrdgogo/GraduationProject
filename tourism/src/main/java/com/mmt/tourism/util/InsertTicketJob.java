package com.mmt.tourism.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertTicketJob{
	
	private static final String insertSql="INSERT INTO t_ticket{?}(id,setMenuId,number) VALUES(?,?,?)";	
	private static final String SelectSql="SELECT id,visitors FROM t_viewsetmenu";	
	private static Logger logger = LoggerFactory.getLogger(InsertTicketJob.class);
	
	protected void run(DataSource dataSource,String dataformat){
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			Map<String,Integer> params=getparams(connection);
			Iterator<Entry<String, Integer>> it=params.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, Integer> en=it.next();
				String id=en.getKey();
				Integer maxNo=en.getValue();
				
				PreparedStatement preparedStatement=connection.prepareStatement((GlobalUtil.margeCmd(insertSql, dataformat)));
				int ticketNo=1;
				while(ticketNo++<=maxNo){
					preparedStatement.setString(1, GlobalUtil.getTicketID(dataformat));
					preparedStatement.setString(2, id);
					preparedStatement.setInt(3, ticketNo);
					preparedStatement.addBatch();
				}
				preparedStatement.executeBatch();
				
			}
			connection.commit();
			logger.info("t_ticket"+dataformat+"表数据插入成功");
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.info("t_ticket"+dataformat+"表数据回滚失败",e);
			}
		}finally{
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					logger.info("连接关闭失败",e);
				}
		}
		
	}
	
	private Map<String,Integer> getparams(Connection connection) throws SQLException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		ResultSet set=connection.createStatement().executeQuery(SelectSql);
		while(set.next()){
			map.put(set.getString(1), set.getInt(2));
		}
		return map;
	}

}
