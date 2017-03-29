package com.mmt.tourism.config.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmt.tourism.service.IOrderJobService;

public class CancelOrderJob implements Job{
	private static IOrderJobService orderJobService;
	//private static final String SelectSql="SELECT id FROM t_order WHERE status='0' AND createDate < ?";	
	private static Logger logger = LoggerFactory.getLogger(CancelOrderJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		orderJobService.cancelOrder();
		logger.info("取消订单");
	}

	public static IOrderJobService getOrderJobService() {
		return orderJobService;
	}

	public static void setOrderJobService(IOrderJobService orderJobService) {
		CancelOrderJob.orderJobService = orderJobService;
	}

}
