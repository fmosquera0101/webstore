package co.com.fredymosquera.webstore.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor  implements HandlerInterceptor {

	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);

		LOGGER.info("Accesing URL path: "+getUrlPath(request));
		LOGGER.info("Request processing started on: "+ getCurrentTime());
		return true;

	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView)throws Exception {
		LOGGER.info("Request processing end on: "+ getCurrentTime());
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		LOGGER.info("Total time taken for processing: "+ stopWatch.getTotalTimeMillis() +" ms");
		System.out.println("Total time taken for processing: "+ stopWatch.getTotalTimeMillis() +" ms");
		stopWatchLocal.set(null);
		LOGGER.info("==========================================================================");
	}

	private String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return DateFormatUtils.format(calendar, "dd/MM/yyyy 'at' hh:mm:ss");
	}

	private String getUrlPath(HttpServletRequest request) {
		StringBuilder urlPath = new StringBuilder();
		urlPath.append(request.getRequestURI());
		urlPath.append(request.getQueryString() == null ? "": "?"+request.getQueryString());

		return urlPath.toString();
	}


}
