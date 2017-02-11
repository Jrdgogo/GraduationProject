package com.mmt.tourism.util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTicketTableJob{
	
	private DataSource dataSource;
	private String createTicketTableSql;
    private Integer createTableDays;
    private static Logger logger = LoggerFactory.getLogger(CreateTicketTableJob.class);
	
	public void execute() throws SQLException{
		Statement statement=dataSource.getConnection().createStatement(); 
		int days=0;
		long time=new Date().getTime();
		while(createTableDays-->0){
			String dataformat=GlobalUtil.dateFormat(time+1000*60*60*24*days,"yyyy_MM_dd");
			statement.execute(GlobalUtil.margeCmd(createTicketTableSql, dataformat,dataformat));
			logger.info("t_ticket"+dataformat+"表创建成功");
			days++;  
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

	public Integer getCreateTableDays() {
		return createTableDays;
	}

	public void setCreateTableDays(Integer createTableDays) {
		this.createTableDays = createTableDays;
	}

	
}
