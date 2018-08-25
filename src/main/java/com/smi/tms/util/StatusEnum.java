package com.smi.tms.util;

public enum StatusEnum {

	YET_TO_START("Yet to Start"),INPROGRESS("Inprogress"),COMPLETED("Completed");
	
	 private String status;
	 
	 StatusEnum(String status){
		 this.status = status;
	 }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.status;
	}
	 
}
