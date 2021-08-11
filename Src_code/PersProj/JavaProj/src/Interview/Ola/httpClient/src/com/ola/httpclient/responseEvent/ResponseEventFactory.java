package com.ola.httpclient.responseEvent;

public class ResponseEventFactory {
	
	
	private static ResponseEventFactory _instance = new ResponseEventFactory();
	
	private ResponseEventFactory(){
		
	}
	
	public static ResponseEventFactory getInstance(){
		return _instance;
	}
	
	public AbstractResponseEvent getResponseEvent(int responseCode){
		
		
		switch(responseCode){
		
		case 400: 
			return new ResponseEvent4xx();
		
		case 500:
			return new ResponseEvent5xx();
		
			default:
				
				return new ResponseEvent4xx();
		}
		
	}

}
