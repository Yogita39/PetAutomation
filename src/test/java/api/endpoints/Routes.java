package api.endpoints;

// create user- post- https://petstore.swagger.io/v2/user
//Get user -get - https://petstore.swagger.io/v2/user/{username}
//Update User -put - https://petstore.swagger.io/v2/user/{username}
//Delete user - delete - https://petstore.swagger.io/v2/user/{username}

public class Routes {
		public static String base_url ="https://petstore.swagger.io/v2";
		//User module
		
		public static String post_url=base_url + "/user" ;
		public static String get_url =base_url + "/+user/{username}";
		public static String update_url=base_url + "/+user/{username}";
		public static String delete_url=base_url + "/+user/{username}";
		
		//store module
		//store module urls
		
		//pet module
		//pet modules urls
}
