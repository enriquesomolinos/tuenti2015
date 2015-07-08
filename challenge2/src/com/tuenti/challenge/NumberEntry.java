package com.tuenti.challenge;


public class NumberEntry {

	Integer factors;
	
	int factor1;
	
	int factor2;
	
	
	public Integer getFactors() {
		return factors;
	}

	public void setFactors(int factors) {
		this.factors = factors;
	}

	public NumberEntry(int factors) {
		super();
		this.factors = factors;
	}
	
	public void  addFactors(int factor,int factor2){
		this.factors++;
		this.factors++;
		this.factor1=factor;
		this.factor2 = factor2;
	}

	public long getFactor1() {
		return factor1;
	}

	public long getFactor2() {
		return factor2;
	}

	
	
	
	
}
