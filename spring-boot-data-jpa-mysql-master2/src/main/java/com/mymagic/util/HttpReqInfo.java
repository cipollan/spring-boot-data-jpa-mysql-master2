package com.mymagic.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpReqInfo {
	
	public HttpReqInfo() {
		super();
		log.info(this.getClass() + "CONSTRUCTOR HttpReqInfo"); 
	}

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void printRequest(HttpServletRequest httpRequest) {
		
		log.info(this.getClass() + " printRequest Headers"); 

	    Enumeration headerNames = httpRequest.getHeaderNames();
	    
	    while(headerNames.hasMoreElements()) {
	        String headerName = (String)headerNames.nextElement();
	        log.info(this.getClass() + " printRequest Headers" + headerName + " = " + httpRequest.getHeader(headerName)); 
	         
	    }

	    System.out.println("Parameters");

	    Enumeration params = httpRequest.getParameterNames();
	    while(params.hasMoreElements()){
	        String paramName = (String)params.nextElement();
	        System.out.println(paramName + " = " + httpRequest.getParameter(paramName));
	    }

	    System.out.println("Row data");
	    System.out.println(extractPostRequestBody(httpRequest));
	}
	
public String getRequestBody(HttpServletRequest httpRequest) {
		
		log.info(this.getClass() + " getRequestBody "); 
	     
	    return(extractPostRequestBody(httpRequest));
	}



	public String extractPostRequestBody(HttpServletRequest request) {
	    if ("POST".equalsIgnoreCase(request.getMethod())) {
	        Scanner s = null;
	        try {
	            s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
	            log.info(this.getClass() + " extractPostRequestBody s" + s ); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return s.hasNext() ? s.next() : "";
	    }
	    return "";
	}

}
