package com.mmt.tourism.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
@Component
public class SchedulerConfig {
	
	private Job job;
	private Trigger cornTrigger;
	private Trigger simpleTrigger;
	private Scheduler scheduler;
	private String cronExpression;
	private int repeatMinutelyForever;
	
	
	
	public int getRepeatMinutelyForever() {
		return repeatMinutelyForever;
	}

	public void setRepeatMinutelyForever(int repeatMinutelyForever) {
		this.repeatMinutelyForever = repeatMinutelyForever;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public JobDetail getJob(Job job){
		return JobBuilder.newJob(job.getClass()).
				withIdentity(job.getClass().getSimpleName(),job.getClass().getSimpleName()).
				build();
	}
	
	public Trigger getSimpleTrigger(){
		return TriggerBuilder.newTrigger().
				withIdentity("simpleTrigger","simpleTrigger").
				withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(repeatMinutelyForever)).
				startNow().build();
	}
	public Trigger getCornTrigger(){
		return TriggerBuilder.newTrigger().
				withIdentity("cornTrigger","cornTrigger").
				withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).
				startNow().build();
	}
	public void start() throws SchedulerException{
		scheduler=StdSchedulerFactory.getDefaultScheduler();
		if(cronExpression!=null){
		          cornTrigger=getCornTrigger();
		         scheduler.scheduleJob(getJob(job), cornTrigger);
		}else{
		         simpleTrigger=getSimpleTrigger();
		         scheduler.scheduleJob(getJob(job), simpleTrigger);
		}
		scheduler.start();
	}
	public void stop() throws SchedulerException{
		scheduler.shutdown();
	}

}
