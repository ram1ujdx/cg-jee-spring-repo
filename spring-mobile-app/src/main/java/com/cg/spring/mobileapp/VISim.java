package com.cg.spring.mobileapp;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("vi")
@Scope("singleton")
@Lazy
public class VISim implements Sim{

	@Value("${vi.browsingSpeed}")
	private float browsingSpeed;
	@Value("${vi.callingCharges}")
	private float callingCharges;
	@Value("#{${vi.supportedNetworks}}")
	private Map<String,Integer> supportedNetworks;
	
	
	@PostConstruct
	public void init() {
		System.out.println("VI Sim Created");
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
		System.out.println("Calling with VI...charges : "+callingCharges);
	}
	
	public void browse() {
		System.out.println("Browsing with VI...speed : "+browsingSpeed+"mb/s");
	}
	
}
