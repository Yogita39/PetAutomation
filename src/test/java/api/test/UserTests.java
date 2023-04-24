package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

		User userpayload;
		
	    @BeforeClass
	    public void setUpData() {
	    	userpayload= new User();
	    	userpayload.setId(2567);
	    	userpayload.setFirstName("Yogita");
	    	userpayload.setLastName("Dighe");
	    	userpayload.setEmail("yogi.di@gmail.com");
	    	userpayload.setPhone("659813265");
	    }
	    
	    @Test(priority=1)
	    public void testPostUser() {
	    	Response response=UserEndpoints.CreateUser(userpayload);
	    	response.then().log().all();
	    	
	    	Assert.assertEquals(response.statusCode(), 200);
	    }
		
	    @Test(priority=2)
	    public void testGetUser() {
	    	Response response=UserEndpoints.GetUser(this.userpayload.getUsername());
	    	response.then().log().all();
	    	
	    	Assert.assertEquals(response.statusCode(), 200);	    	
	    }
	    
	    @Test(priority=3)
	    public void testUpdateUserByName() {
	    	//Update data
	    	userpayload= new User();
	    	userpayload.setId(2567);
	    	userpayload.setFirstName("Sagar");
	    	userpayload.setLastName("Digh");

	    	
	    	Response response=UserEndpoints.UpdateUser(this.userpayload.getUsername(), userpayload);
	    	response.then().log().body().statusCode(200);
	    	
	    	//Assert.assertEquals(response.statusCode(), 200);
	    	
	    	//Check data is updated
	    	Response responseafterupdate=UserEndpoints.GetUser(this.userpayload.getUsername());   
	    	Assert.assertEquals(response.statusCode(), 200);	    	    	
	    }
	    
	    @Test(priority=4)
	    public void testDeleteUser() {
	    	Response response=UserEndpoints.DeleteUser(this.userpayload.getUsername());
	    	Assert.assertEquals(response.statusCode(), 200);
	    }
}
