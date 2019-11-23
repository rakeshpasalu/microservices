package com.microservice.client2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class MainController {
	 @Autowired
	    private DiscoveryClient discoveryClient;

	    @GetMapping("/demotest")
	    public String handleRequest(Model model) {
	        //accessing hello-service
	    	System.out.println("webservice cllient");
	    	
	        //List<ServiceInstance> instances = discoveryClient.getInstances("hello-service");
	    	List<ServiceInstance> instances = discoveryClient.getInstances("client1-service");
	        System.out.println(instances.size());
	        if (instances != null && instances.size() > 0) {//todo: replace with a load balancing mechanism
	        	try {
	        		  
	        	
	        	System.out.println("ïnstances count greater than zero");
	            ServiceInstance serviceInstance = instances.get(0);
	            String url = serviceInstance.getUri().toString();
	            //url = url + "/demo";
	            url =  "http://localhost:8080/demo";
	            System.out.println("url is "+url);
	            RestTemplate restTemplate = new RestTemplate();
	            
	            Object helloObject = restTemplate.getForObject(url,
	                    Object.class);
	            model.addAttribute("msg", helloObject.getMessage());
	           
	        	}catch (Exception e) {
					// TODO: handle exception
	        		e.getMessage();
	        		e.printStackTrace();
				}
	        }
	        
	       // jsp call;
	        return "welcome";
	    }
}
