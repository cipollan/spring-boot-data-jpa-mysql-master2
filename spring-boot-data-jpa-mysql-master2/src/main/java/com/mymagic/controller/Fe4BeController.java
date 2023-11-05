package com.mymagic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymagic.model.User;
import com.mymagic.service.JwtTokenUtil;
import com.mymagic.util.HttpReqInfo;


@RestController 
@RequestMapping("/fe4be-controller")
public class Fe4BeController {
	
	
	@Autowired 
	JwtTokenUtil jwtTokenUtil;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	public static  int i = 1;

	public Fe4BeController() 
	{
		log.info(this.getClass() + " Fe4BeController"  );
		
	}
	
	@GetMapping("/hellogetcontroller")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) 
	{
		log.info(this.getClass() + " MysprprjApplication.hello value=" + (name));
		return String.format("Hello %s!", name);
	}
	
	
	@GetMapping("/getjwttoken")
	public String getjwttoken(@RequestParam(value = "name", defaultValue = "World") String name) 
	{
		String token ;
		log.info(this.getClass() + " MysprprjApplication.getjwttoken value=" + (name));
		
		token = jwtTokenUtil.generateToken(name);
		
		log.info(this.getClass() + " MysprprjApplication.getjwttoken token=" + (token));
		
		return token;
	}
	
	
	@GetMapping("/hellogetuser")
	public User getUser(@RequestBody User name)
	{
		log.info(this.getClass() + " Fe4BeController.hellogetuser" );
		log.info(this.getClass() + " Fe4BeController.getName	=" + (name.getName()));
		log.info(this.getClass() + " Fe4BeController.getPassword=" + (name.getEmail()));
		User u = new User();
		u.setId(11111);
		u.setName(name.getName());
		u.setEmail("aaaa@gmail.com");
				;
		log.info(this.getClass() +  " Fe4BeController.hello value=" + (name));
		
		return u;
	}
	
	@PostMapping("/saveData")
	@ResponseBody
	public ResponseEntity<User> saveData(HttpServletRequest request,
	            HttpServletResponse response, 
	            Model model)
	{
	     setI(1 + 1);
	   log.info(this.getClass() + " fe4be-controller saveData:" +  (getI()));
	   String requestgetmethod = request.getMethod();
	   HttpReqInfo httpReqInfo = new HttpReqInfo();
	   
	   httpReqInfo.printRequest(request);
	   
	   log.info(this.getClass() + " fe4be-controller saveData:" + (requestgetmethod));
	   
	   HttpHeaders responseHeaders = new HttpHeaders();
	   
       User user = new User();
	   ResponseEntity<User> re = new ResponseEntity<User> (user, responseHeaders, HttpStatus.OK);
        
	   return re;
	   
	}
	@PostMapping("/saveUser")
	@ResponseBody
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
	   log.info(this.getClass() + " fe4be-controller saveUser:");
	   setI(getI() + 1);
	   
	   HttpHeaders responseHeaders = new HttpHeaders();
	   
        user.setId(this.getI());
	   ResponseEntity<User> re = new ResponseEntity<User> (user, responseHeaders, HttpStatus.OK);
        
	   return re;
	   
	}
	
	@PostMapping("/hellopostcontroller")
	public String helloP(@RequestParam(value = "name", defaultValue = "World") String name) 
	{
		log.info(this.getClass() + " MysprprjApplication.hello value=" + (name));
		return String.format("Hello %s!", name);
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		Fe4BeController.i = i;
	}
	
}
