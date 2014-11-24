package com.gitsea.bootstrap.elasticsearch;

/**
 * @ClassName:     IPAddress.java
 * @Description:   TODO
 * @author         FrankWong
 * @version        V1.0  
 */
public class IPAddress {

	private String ip;
	private int port;
	
	public IPAddress(){
		
	}
	
	public IPAddress(String ip){
		this.ip = ip;
		this.port = Constant.ES_DEFAULT_PORT;
	}
	
	public IPAddress(String ip,int port){
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		if( port <= 0){
			return 9300;
		}
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
