package Asymmetrik;

public class ContactInfo {

	//instance variables
	private String name;
    private String phone;
    private String email;
    
    private String [] disqualify = {"Engineer", "Senior", "Analyst", "LTD", "Technologies", "Foobar", "Business", "Manager",
    		"Software", "Fax", "fax", "Recruiter", "Intern", "Talent", "Acqusition", "Specialist", "Developer", "Human", "Resource", "Representative", "Analytical"};  //list of words that would disqualify a line from being a name/email/phone number
    private String nameRegEx = "^([A-Z][a-z]*\\.?((\\s)))+[A-Z][a-z]+( [A-Z]+)?$"; //regex for name
    private String phoneRegex = "^.*\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"; //regex for phone number
    private String emailRegex = ".*[\\w\\.]+@[\\w]+\\.[\\w]+"; //regex for email
    
    //constructor parses the information and loads default values if the program fails.
    public ContactInfo(String document){
    	this.name = "No Name Found";
    	this.phone = "No Phone Number Found";
    	this.email = "No Email Address Found";
    	parseCard(document);   
    }

    
//standard getter methods
    
    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
    
    public String getEmail(){
        return email;
    }
    
    
    private void parseCard(String document) {
    	String[] lines = document.split("\n");
    	for (String line:lines) {
    		boolean parse = true;
    		for(String disqualifier:disqualify) {
    			if (line.contains(disqualifier)) {
    				parse = false;                //if any line contains any of the disqualifying word, that line is not parsed
    			} 
    		}
    		if (parse) {
    			parseLine(line);  //if no disqualifying words found the line is parsed
    		}
    	}
    }
    
    private void parseLine(String line) {
    	if (line.matches(nameRegEx)) {  //checks if the line fits the pattern of a name
    		this.name = line;
    	} else if (line.matches(phoneRegex)){   //checks if line fits pattern of a phone number
    		line = line.replaceAll("[^\\d]", ""); //removes all characters that are not numbers
    		this.phone = line;
    	} else if (line.matches(emailRegex)) {    //checks if line fits pattern of an email address
    		String [] possiblyEmail = line.split(" ");
    		if (possiblyEmail.length > 1) {   //if email has some sort of label before, this breaks it apart
    			this.email = possiblyEmail[1];
    		} else {
    			this.email = possiblyEmail[0];
    		}
    	}
    	
    }

}




