package com.mmt.tourism.config.scheduler.job;

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

import com.mmt.tourism.util.GlobalUtil;

public class TicketTableJob implements Job {

	private static DataSource dataSource;
	private static String createTicketTableSql;
	private static String dropTicketTableSql;
	private static Integer days;
	private static Logger logger = LoggerFactory.getLogger(TicketTableJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Connection connection = null;
		try {
			long time = new Date().getTime();
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			String dataformat = GlobalUtil.ticketFormat(time + 1000 * 60 * 60 * 24 * (days - 1));
			statement.execute(GlobalUtil.margeCmd(createTicketTableSql, dataformat, dataformat));
			logger.info("t_ticket" + dataformat + "表创建成功");

			new InsertTicketJob().run(dataSource, dataformat);

			dataformat = GlobalUtil.ticketFormat(time - 1000 * 60 * 60 * 24);
			statement.execute(GlobalUtil.margeCmd(dropTicketTableSql, dataformat));
			logger.info("t_ticket" + dataformat + "表删除成功");

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				logger.error("t_ticket表回滚错误", e);
			}
			logger.error("t_ticket表操作出错", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("连接关闭失败", e);
				}
			}
		}

	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		TicketTableJob.dataSource = dataSource;
	}

	public static String getCreateTicketTableSql() {
		return createTicketTableSql;
	}

	public static void setCreateTicketTableSql(String createTicketTableSql) {
		TicketTableJob.createTicketTableSql = createTicketTableSql;
	}

	public static String getDropTicketTableSql() {
		return dropTicketTableSql;
	}

	public static void setDropTicketTableSql(String dropTicketTableSql) {
		TicketTableJob.dropTicketTableSql = dropTicketTableSql;
	}

	public static Integer getDays() {
		return days;
	}

	public static void setDays(Integer days) {
		TicketTableJob.days = days;
	}

}
