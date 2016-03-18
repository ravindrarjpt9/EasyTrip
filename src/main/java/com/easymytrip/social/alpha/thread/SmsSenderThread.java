package com.easymytrip.social.alpha.thread;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import com.easymytrip.social.alpha.constants.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SmsSenderThread implements Runnable{

	private static final Logger LOG = Logger
			.getLogger(SmsSenderThread.class);

	private long toMobileNumber;
	private String message;
	private String code;
	
	
	public SmsSenderThread() {
		
	}
	
	public SmsSenderThread(long toMobileNumber, String code) {
		
		this.toMobileNumber = toMobileNumber;
		this.code = code;
	}


	@Override
	public void run() {
		String url = "";
		String tId = "";
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	    params.add("usr",Constants.SMS_USER);
	    params.add("key",Constants.SMS_KEY);
	    params.add("smstype",Constants.SMS_TYPE);
	    params.add("to",toMobileNumber+"".trim());
	    params.add("msg",Constants.SMS_MSG.replace("#code#", code));
	    params.add("rout",Constants.SMS_ROUT);
	    params.add("from",Constants.SMS_FROM);
	    
		try{
		LOG.info("*** Going to send OTP to ["+toMobileNumber+"] code ["+code+"]");
		 url = Constants.SMS_SERVICES_URL;
				 //"?usr="+Constants.SMS_USER+"&key="+Constants.SMS_KEY+"&smstype="+Constants.SMS_TYPE+"&to="+toMobileNumber+"&msg="+Constants.SMS_MSG.replace("#code#", code)+"&rout="+Constants.SMS_ROUT+"&from="+Constants.SMS_FROM;
		
		 Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.queryParams(params).get(ClientResponse.class); 
		if(resp.getStatus() != 200){ 
			LOG.error(" ****** error while sending OTP to ["+toMobileNumber+"] code ["+code+"] **** Unable to connect to the server");
		} 
		String output = resp.getEntity(String.class);
		tId = output.substring(output.indexOf("-")+1);
		LOG.info(" OTP to ["+toMobileNumber+"] code ["+code+"] TransactionId ["+tId+"]" );
		}catch (Exception e) {
			LOG.error("Error while send OTP to user ["+url+"]",e);
			Client restClient = Client.create();
			WebResource webResource = restClient.resource(url);
			ClientResponse resp = webResource.queryParams(params).get(ClientResponse.class); 
			if(resp.getStatus() != 200){ 
				LOG.error(" ****** error while sending OTP to ["+toMobileNumber+"] code ["+code+"] **** Unable to connect to the server");
			} 
			String output = resp.getEntity(String.class);
			tId = output.substring(output.indexOf("-")+1);
			LOG.info(" OTP to ["+toMobileNumber+"] code ["+code+"] TransactionId ["+tId+"]" );
		}
		
		LOG.info("**** Fine put Delivery report of TransactionId ["+tId+"]" );
		try{
			
			params.clear();
			 params.add("usr",Constants.SMS_USER_NAME);
			 params.add("pwd",Constants.SMS_PASSWORD);
			 params.add("type","delivery");
			 params.add("transactionId",tId);
	
		 url = Constants.SMS_SERVICES_URL;
				 //"?usr="+Constants.SMS_USER_NAME+"&pwd="+Constants.SMS_PASSWORD+"&type=delivery"+"&transactionId="+tId;

		 Client restClient = Client.create();
			WebResource webResource = restClient.resource(url);
			ClientResponse resp = webResource.queryParams(params).get(ClientResponse.class); 
			if(resp.getStatus() != 200){ 
				LOG.error(" ****** error while getting Delivery to ["+toMobileNumber+"] code ["+code+"] TransactionId ["+tId+"]**** Unable to connect to the server");
			} 
			String output = resp.getEntity(String.class);
			LOG.info("TransactionId ["+tId+"] Delivery report ["+output+"]");
		}catch(Exception e)
		{
			LOG.error("Error while getting Delivery report of TransactionId ["+tId+"]",e);
		}
		
	
}


	public long getToMobileNumber() {
		return toMobileNumber;
	}


	public String getMessage() {
		return message;
	}


	public String getCode() {
		return code;
	}


	public void setToMobileNumber(long toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setCode(String code) {
		this.code = code;
	}
}
