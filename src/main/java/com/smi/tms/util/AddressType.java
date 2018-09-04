package com.smi.tms.util;

public enum AddressType {

	PRESENT("Present"),PERMANENT("Permanent");
	
	 private String addrType;
	 
	 AddressType(String addrType){
		 this.addrType = addrType;
	 }
	 
	 public String getAddrType() {
		return addrType;
	}

	 public void setAddrType(String addrType) {
		this.addrType = addrType;
	}




@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.addrType;
	}
	 
}
