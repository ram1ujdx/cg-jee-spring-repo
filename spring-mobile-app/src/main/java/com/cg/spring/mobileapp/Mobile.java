package com.cg.spring.mobileapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mobile {


	@Autowired
	@Qualifier("airtelSim")
	private Sim sim;
	
	
	
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
