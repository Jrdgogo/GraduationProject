package com.mmt.tourism.util;

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
		try {
			long time=new Date().getTime();
			Statement statement=dataSource.getConnection().createStatement(); 
			String dataformat=GlobalUtil.dateFormat(time+1000*60*60*24*(days-1),"yyyy_MM_dd");
			statement.execute(GlobalUtil.margeCmd(createTicketTableSql, dataformat,dataformat));
			logger.info("t_ticket"+dataformat+"表创建成功");
			dataformat=GlobalUtil.dateFormat(time,"yyyy_MM_dd");
			statement.execute(GlobalUtil.margeCmd(dropTicketTableSql, dataformat));
			logger.info("t_ticket"+dataformat+"表删除成功");
		} catch (SQLException e) {
			logger.error("t_ticket表出错", e);
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
