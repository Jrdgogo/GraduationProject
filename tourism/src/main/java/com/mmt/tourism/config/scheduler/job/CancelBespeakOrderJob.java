package com.mmt.tourism.config.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmt.tourism.service.IOrderJobService;

public class CancelBespeakOrderJob implements Job{
	private static IOrderJobService orderJobService;
	//private static final String SelectSql="SELECT id FROM t_order WHERE status='0' AND createDate < ?";	
	private static Logger logger = LoggerFactory.getLogger(CancelBespeakOrderJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		orderJobService.cancalBackOrder();
		logger.info("取消预约订单");
	}

	public static IOrderJobService getOrderJobService() {
		return orderJobService;
	}

	public static void setOrderJobService(IOrderJobService orderJobService) {
		CancelBespeakOrderJob.orderJobService = orderJobService;
	}

}
