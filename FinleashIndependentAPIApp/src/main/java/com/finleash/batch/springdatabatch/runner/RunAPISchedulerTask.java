package com.finleash.batch.springdatabatch.runner;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.util.concurrent.Uninterruptibles;

public class RunAPISchedulerTask extends TimerTask{
	private final static Logger log = LoggerFactory.getLogger(RunAPISchedulerTask.class);

	
	@Override
	public void run() {
		log.debug("---------------------------------------------------RunAPISchedulerTask Start---------------------------------------------------------------------------");
		final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.getBean("runner",Runner.class).run();
		Uninterruptibles.sleepUninterruptibly(900, TimeUnit.SECONDS);
		log.debug("---------------------------------------------------RunAPISchedulerTask End---------------------------------------------------------------------------");
		
	}
}

