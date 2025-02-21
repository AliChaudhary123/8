package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReliefService {
	
	private Inquirer inquirer;
	private DisasterVictim missingPerson;
	private String dateOfInquiry;
	private String infoProvided;
	private Location lastKnownLocation;
	
	public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
		this.inquirer = inquirer;
		this.missingPerson = missingPerson;
		setDateOfInquiry(dateOfInquiry);
		this.infoProvided = infoProvided;
		this.lastKnownLocation = lastKnownLocation;
	}
	
	public Inquirer getInquirer() {
		return inquirer;
	}
	
	public void setInquirer(Inquirer inquirer) {
		this.inquirer = inquirer;
	}
	
	public DisasterVictim getMissingPerson() {
		return missingPerson;
	}
	
	public void setMissingPerson(DisasterVictim missingPerson) {
		this.missingPerson = missingPerson;
	}
	
	public String getDateOfInquiry() {
		return dateOfInquiry;
	}
	
	public void setDateOfInquiry(String dateOfInquiry) {
		if (isValidDateFormat(dateOfInquiry)) {
            this.dateOfInquiry = dateOfInquiry;
        } else {
            throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD");
        }
	}
	
	public String getInfoProvided() {
		return infoProvided;
	}
	
	public void setInfoProvided(String infoProvided) {
		this.infoProvided = infoProvided;
	}
	
	public Location getLastKnownLocation() {
		return lastKnownLocation;
	}
	
	public void setLastKnownLocation(Location lastKnownLocation) {
		this.lastKnownLocation = lastKnownLocation;
	}
	
	public boolean isValidDateFormat(String date) { 

        Pattern dateFormat = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");  // Only allowing the YYYY-MM-DD format
        Matcher myMatcher = dateFormat.matcher(date); 
        return myMatcher.matches(); 

    } 
	
	public String getLogDetails() {
		String inquirerDetails;
		if (inquirer != null) {
		    inquirerDetails = "Inquirer: " + inquirer.getLastName();
		} else {
		    inquirerDetails = "Unknown";
		}
		
		String missingPersonDetails;
		if (missingPerson != null) {
			missingPersonDetails = "Missing Person: " + missingPerson.getLastName();
		} else {
			missingPersonDetails = "Unknown";
		}
		
		String dateDetails = "Date of Inquiry: " + dateOfInquiry;
		
		String infoDetails;
		if (infoProvided != null) {
			infoDetails = "Info: " + infoProvided;
		} else {
			infoDetails = "Unknown";
		}
		
		String locationDetails;
		if (lastKnownLocation != null) {
			locationDetails = "Last Known Location: " + lastKnownLocation.getAddress();
		} else {
			locationDetails = "Unknown";
		}
		
		String logDetails = inquirerDetails + ", " + 
							missingPersonDetails + ", " + 
							dateDetails + ", " + 
							infoDetails + ", " + 
							locationDetails;
		
		return logDetails;
	}
}
