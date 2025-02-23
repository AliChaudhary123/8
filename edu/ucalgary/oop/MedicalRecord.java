package edu.ucalgary.oop; 

import java.util.regex.*; 

public class MedicalRecord { 

    private Location location; 
    private String treatmentDetails; 
    private String dateOfTreatment; 

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) { 
        this.location = location; 
        this.treatmentDetails = treatmentDetails; 
        setDateOfTreatment(dateOfTreatment); 
    } 

    public Location getLocation() { 
        return location; 
    } 

    public void setLocation(Location location) { 
        this.location = location; 
    } 

    public String getTreatmentDetails() {
        if (treatmentDetails == null || treatmentDetails.trim().isEmpty()) {
            throw new IllegalArgumentException("Treatment details must not be null or empty.");
        }
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) { 
        this.treatmentDetails = treatmentDetails; 
    } 

    public String getDateOfTreatment() { 
        return dateOfTreatment; 
    } 

    public void setDateOfTreatment(String dateOfTreatment) {
        if (isValidDateFormat(dateOfTreatment)) {
            this.dateOfTreatment = dateOfTreatment;
        } else {
            throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD");
        }
    }

    private boolean isValidDateFormat(String date) { 

        Pattern dateFormat = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");  // Only allowing the YYYY-MM-DD format
        Matcher myMatcher = dateFormat.matcher(date); 
        return myMatcher.matches(); 

    } 

} 