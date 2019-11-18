package com.test;
import org.junit.Assert;

import org.junit.Test;
import com.request.Request;

public class RequestTest {

	@Test
	public void getRequestTypeTest(){
		Request.RequestType type = Request.RequestType.OPENJOINTACCOUNT; 
		Request.RequestStatus status = Request.RequestStatus.ONHOLD;
		Request MyRequest = new Request(type,status,123456789);
		Assert.assertEquals(type, MyRequest.getRequestType());
	}
	
	@Test
	public void setRequestTypeTest(){
		Request.RequestType type = Request.RequestType.OPENNORMALACCOUNT; 
		Request.RequestStatus status = Request.RequestStatus.ONHOLD;
		Request MyRequest = new Request(type,status,123456789);
		MyRequest.setRequestType(Request.RequestType.CLOSENORMALACCOUNT);
		Assert.assertEquals(Request.RequestType.CLOSENORMALACCOUNT, MyRequest.getRequestType());
	}
	
	@Test
	public void getRequestStatusTest(){
		Request.RequestType type = Request.RequestType.OPENJOINTACCOUNT; 
		Request.RequestStatus status = Request.RequestStatus.ONHOLD;
		Request MyRequest = new Request(type,status,123456789);
		Assert.assertEquals(Request.RequestStatus.ONHOLD, MyRequest.getRequestStatus());
	}
	
	@Test
	public void setRequestStatusTest(){
		Request.RequestType type = Request.RequestType.OPENJOINTACCOUNT; 
		Request.RequestStatus status = Request.RequestStatus.ONHOLD;
		Request MyRequest = new Request(type,status,123456789);
		MyRequest.setRequestStatus(Request.RequestStatus.APPROVED);
		Assert.assertEquals(Request.RequestStatus.APPROVED, MyRequest.getRequestStatus());
	}
	
	@Test
	public void getAssociatedBankIDTest(){
		Request.RequestType type = Request.RequestType.OPENJOINTACCOUNT; 
		Request.RequestStatus status = Request.RequestStatus.ONHOLD;
		Request MyRequest = new Request(type,status,123456789);
		Assert.assertEquals(123456789, MyRequest.getAssociatedBankID());
	}
}


