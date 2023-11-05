package com.mymagic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mymagic.service.JwtTokenUtil;

@RestController
@RequestMapping("/TokenController")
public class TokenController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

    private final JwtTokenUtil jwtTokenUtil;

    public TokenController(JwtTokenUtil jwtTokenUtil) 
    {
        this.jwtTokenUtil = jwtTokenUtil;
        
        log.info(this.getClass() + " TokenController " + jwtTokenUtil );
    }
    
    
   
    

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestParam("username") String username) 
    {
    	log.info(this.getClass() + " generateToken " + username );
    	
        String token = jwtTokenUtil.generateToken(username);
        
        log.info(this.getClass() + " generateToken " + token );
        
        return ResponseEntity.ok(token);
    }
}

