package com.test;

import java.io.IOException;
import org.junit.Assert;

import org.junit.Test;
import java.util.ArrayList;

import com.dataHandler.DataHandler;
import com.dataHandler.EntityInfoDatabase;
import com.entityInfo.CustomerInfo;


public class DataHandlerTest {

	
	public void initializeFileSystemTest() {
		try {
			DataHandler.initializeFileSystem();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    
    public void readCustomerInfoTest() {
    	try {
    		DataHandler.initializeFileSystem();
			EntityInfoDatabase<CustomerInfo> obj = DataHandler.readCustomerInfo();
			   Assert.assertEquals(0, obj.getFullEntityInfo().size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
   @Test
    public void storeCustomerInfoTest(){
		try {
			DataHandler.initializeFileSystem();
			EntityInfoDatabase<CustomerInfo> obj;
			obj = DataHandler.readCustomerInfo();
			obj.addEntityInfo(new CustomerInfo("Akeem","dafemart","naruto1234",123456789));
			DataHandler.storeCustomerInfo(obj);
			obj = DataHandler.readCustomerInfo();
			ArrayList<CustomerInfo> list = obj.getFullEntityInfo();
			String name = list.get(0).getName();
			 Assert.assertEquals("Akeem",name); 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
    
	

