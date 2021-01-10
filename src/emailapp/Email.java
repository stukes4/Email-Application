package emailapp;
import java.util.Scanner;

public class Email {
private String firstname;
private String lastname;
private String password;
private String Department;
private String email;
private int mailboxcapacity = 500;
private String altemail;
private String companysuffix = "company.com";

//constructor to receive first and last name
public Email(String firstname, String lastname) {
	this.firstname = firstname; /*"this" refers to the class level variable, and this line is initializing
	to the local variable*/
	this.lastname = lastname;
	System.out.println(this.firstname + " " + this.lastname);
	
	//call a method asking for the department, and return the department
	this.Department = setDepartment(); //setting the private department variable to the setDepartment method
	
	
	this.password = setPassword(10);
	System.out.println("Password: " + this.password);
	
	//combine elements to generate email
	email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + Department +  "." +companysuffix;
	
}

//ask for the department
private String setDepartment() {
	System.out.print("Enter the department number \n1 for sales\n2 for developement\n3 for accounting\n0 for none");
	Scanner n = new Scanner(System.in);
	int depChoice =n.nextInt();
	if(depChoice == 1) { return "sales";}
	
	else if(depChoice == 2) {return "development";}
	
	else if(depChoice == 3) {return "accounting";}
	
	else {return "no department";}
	
	
}

//generate a random password
private String setPassword(int length) {
	String passwordset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&"; //the characters that will be chosen for the password are in this string
	char[]password = new char[length];
	for(int i = 0;i < length; i++) {
		int ran = (int) (Math.random()*passwordset.length());
		/*Math.random generates a double type number between 0.0 and 1.0. This line is 
		 * multiplying the number the method generates by the passwordset's length, and places it as ran*/
		password[i] = passwordset.charAt(ran);//chooses a random character during each traversal
		
	}
	return new String (password);//since password is a char, we have to change it to a string
}


//set the mailbox capacity
public void setcapacity(int capacity) {
	this.mailboxcapacity = capacity;
}

//get mailbox capacity.We are accessing the private class variables through public methods
public int getmailboxcapacity() {
	return mailboxcapacity;
}

//set alternate email
public void setAlternate(String alt) {
	this.altemail = alt;
}

public String getaltemail() {
	return altemail;
}
//change the password
public void ChangePassword(String Change) {
	this.password = Change;
}

public String getpassword() {
	return password;
}

public String getinfo() {
	//this will display the users name,email, and mailbox capacity
	return "Display name: " + firstname + " " + lastname + 
			"\nCompany email: " + email + 
			"\nMailbox capacity: " + mailboxcapacity + "mb";
	
}


}
