package com.cg.spring.mobileapp;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("airtel")
@Scope("singleton")
@Lazy
public class AirtelSim implements Sim, InitializingBean, DisposableBean {

	@Value("${airtel.browsingSpeed}")
	private float browsingSpeed;
	@Value("${airtel.callingCharges}")
	private float callingCharges;
	@Value("#{${airtel.supportedNetworks}}")
	private Map<String,Integer> supportedNetworks;
	
	public AirtelSim() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Airtel Sim Initialized");
	}
	
//	@PostConstruct
//	public void init() {
//		System.out.println("Init Method Executed");
//	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@PreDestroy
	public void destoyMethod() {
		
	}
	


	public AirtelSim(float browsingSpeed, float callingCharges) {
		this.browsingSpeed = browsingSpeed;
		this.callingCharges = callingCharges;
	}






	public Map<String, Integer> getSupportedNetworks() {
		return supportedNetworks;
	}
	public void setSupportedNetworks(Map<String, Integer> supportedNetworks) {
		this.supportedNetworks = supportedNetworks;
	}
	public void showSupportedNetworks() {
		supportedNetworks.forEach((net,year)->System.out.println(net+" -- "+year));
	}
	public float getBrowsingSpeed() {
		return browsingSpeed;
	}


	public void setBrowsingSpeed(float browsingSpeed) {
		this.browsingSpeed = browsingSpeed;
	}

	public float getCallingCharges() {
		return callingCharges;
	}

	public void setCallingCharges(float callingCharges) {
		this.callingCharges = callingCharges;
	}

	public void call() {
		System.out.println("Calling with Airtel...charges : "+callingCharges);
	}

	public void browse() {
		System.out.println("Browsing with Airtel...speed : "+browsingSpeed+"mb/s");
	}

}
