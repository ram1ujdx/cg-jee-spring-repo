package com.cg.spring.mobileapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Mobile {


	@Autowired
	@Qualifier("vi")
	private Sim sim;
	
	@PostConstruct
	public void init() {
		System.out.println("Mobile initialized");
	}
	
	public Sim getSim() {
		return sim;
	}

	public void setSim(Sim sim) {
		this.sim = sim;
	}

	void makeCall() {
		sim.call();
	}
	
	void browse() {
		sim.browse();
	}
	public void showSupportedNetworks() {
	
		System.out.println("Supported Networks are: ");
		sim.showSupportedNetworks();
	}
	
	
}
