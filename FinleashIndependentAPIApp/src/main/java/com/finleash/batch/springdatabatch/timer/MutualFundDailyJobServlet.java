package com.finleash.batch.springdatabatch.timer;


import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.finleash.batch.springdatabatch.runner.RunAPISchedulerTask;
  

public class MutualFundDailyJobServlet extends HttpServlet {
	private final static Logger log = LoggerFactory.getLogger(MutualFundDailyJobServlet.class);

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer timer = null;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		log.debug("---------------------------[MutualFundDailyJobServlet] loaded-------------------------------------------");

    }
     
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
     
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
     
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "MutualFundDailyJobServlet";
    }
  
    // Make sure we cancel the timer if the servlet is terminated
    public void destroy() {
        timer.cancel();
        super.destroy();
    }
  
     
    public void init() throws ServletException {
		log.debug("-------------------------------------[timer] init start-------------------------------------------------");

         
       
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 2);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);

		//
        TimerTask task = new RunAPISchedulerTask();

		Timer timer = new Timer();
		//timer.schedule(task, 1000, 60000);
		// every night at 2am you run your task
		timer.schedule(task, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms
	
        log.debug("-------------------------------------[timer] init end-------------------------------------------------");

        
    }
     
        class ReportGenerator extends TimerTask {
         
        public void run() {
         
        }
         
    }
}