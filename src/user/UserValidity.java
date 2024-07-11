package user;

public class UserValidity { 
	/*
	 * Checks if the password iş meeting the criterias returns true if it is
	 */
	public static boolean passwordValidity(String password) {
		
		if(password.length() > 8 && password.matches(".*\\d.*") == true && 
				password.matches(".*[a-zA-Z].*") == true && password.matches("[^a-zA-Z0-9]+") == false ) {
			
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	/*
	 * Checks if the name and surname iş meeting the criterias return true if it is
	 */
	public static boolean nameValidity(String name) {
		
		if(name.matches("^[a-zA-Z]*$") == true && name.length() >= 3) {
			
			return true;
			
		}
		
		else {
			
			return false;
		}
	}
	/*
	 * Checks if the age iş meeting the criterias return true if it is
	 */
	public static boolean ageValidity(int age) {
		
		if(age > 12) {
			
			return true;
			
		}
		else {
			
			return false;
		}

	
	}
	/*
	 * Checks if the username iş meeting the criterias return true if it is
	 */
	public static boolean usernameValidity(String username) {
		
		boolean result = true;
		
		if(username.length() > 0) {
			
			for (int i = 0; i < username.length(); i++) {
		         
		         if ((Character.isLetterOrDigit(username.charAt(i)) == false)) {
		            result = false;
		         }
		      }
		    return result;
		}
		else {
			return false;
		}
	}
	/*
	 * Checks if the email iş meeting the criterias return true if it is true
	 */
	public static boolean emailValidity(String email) {
		
		if(email.contains("@")) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	

}
