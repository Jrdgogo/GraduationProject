package com.mmt.tourism.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketTableJob implements Job {
	
	private DataSource dataSource;
	private String createTicketTableSql;
    private String dropTicketTableSql;
    private Integer days;
    private static Logger logger = LoggerFactory.getLogger(TicketTableJob.class);
	
    @Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
    	Connection connection=null;
    	try {
			long time=new Date().getTime();
			connection=dataSource.getConnection();
			connection.setAutoCommit(false);
			Statement statement=connection.createStatement(); 
			String dataformat=GlobalUtil.dateFormat(time+1000*60*60*24*(days-1),"yyyy_MM_dd");
			statement.execute(GlobalUtil.margeCmd(createTicketTableSql, dataformat,dataformat));
			logger.info("t_ticket"+dataformat+"表创建成功");
			
			new InsertTicketJob().run(dataSource, dataformat);
			
			dataformat=GlobalUtil.dateFormat(time-1000*60*60*24,"yyyy_MM_dd");
			statement.execute(GlobalUtil.margeCmd(dropTicketTableSql, dataformat));
			logger.info("t_ticket"+dataformat+"表删除成功");
			
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				logger.error("t_ticket表回滚错误", e);
			}
			logger.error("t_ticket表操作出错", e);
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("连接关闭失败", e);
				}
			}
		}
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getCreateTicketTableSql() {
		return createTicketTableSql;
	}

	public void setCreateTicketTableSql(String createTicketTableSql) {
		this.createTicketTableSql = createTicketTableSql;
	}

	public String getDropTicketTableSql() {
		return dropTicketTableSql;
	}

	public void setDropTicketTableSql(String dropTicketTableSql) {
		this.dropTicketTableSql = dropTicketTableSql;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

    
}
