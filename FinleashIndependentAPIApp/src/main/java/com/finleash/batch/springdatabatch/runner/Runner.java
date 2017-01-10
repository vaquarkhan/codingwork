package com.finleash.batch.springdatabatch.runner;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.finleash.batch.springdatabatch.util.FileUtil;

@Component(value="runner")
public class Runner {

	private final static Logger log = LoggerFactory.getLogger(Runner.class);

	
	@Inject 
	private FileUtil fileUtil;
	
	public void run(){
		log.debug("---------------------------------------------------Runner Start---------------------------------------------------------------------------");
		fileUtil.initiateMutualFundNavETL() ;
		log.debug("---------------------------------------------------Runner End---------------------------------------------------------------------------");

	}
	
}
