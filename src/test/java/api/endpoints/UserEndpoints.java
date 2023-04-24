package api.endpoints;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import api.payload.User;
import io.restassured.response.Response;
public class UserEndpoints {
	
		public static Response CreateUser(User payload){
			
			Response response=given()
					.contentType ("application/json")
					.accept("application/json")
					.body(payload)					
			.when()
					.post(Routes.post_url);
		      return response;
		}
		
public static Response GetUser(String Username) {	
	Response response =given()
			.pathParam("username", Username)
	.when()
		.get(Routes.get_url);
	return response;
}

public static Response UpdateUser(String Username, User payload) {
	Response response=given()
			.contentType("application/json")
			.accept("application/json")
			.pathParam("username", Username)
			.body(payload)
	.when()
			.put(Routes.update_url);
	return response;
}

public static Response DeleteUser(String Username) {	
	Response response =given()
			.pathParam("username", Username)
	.when()
		.delete(Routes.delete_url);
	return response;
}


}
