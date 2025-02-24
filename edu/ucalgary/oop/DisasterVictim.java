package edu.ucalgary.oop;

import java.util.regex.*;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;
    private static int counter = 0;

    public DisasterVictim(String firstName, String ENTRY_DATE){
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        counter++;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();

    }
    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) throws IllegalArgumentException{
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        if (isValidDateFormat(dateOfBirth)) {
            this.dateOfBirth = dateOfBirth;
        }
        else{
            throw new IllegalArgumentException();
        }
        counter++;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException{
        if (isValidDateFormat(dateOfBirth)) {
            this.dateOfBirth = dateOfBirth;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getAssignedSocialID(){
        return this.ASSIGNED_SOCIAL_ID;
    }

    public FamilyRelation[] getFamilyConnections(){
        return this.familyConnections;
    }
    public void setFamilyConnections(FamilyRelation[] connections){
        this.familyConnections = connections;
    }
    public void addFamilyConnection(FamilyRelation record){
        // NOTE: Should I be using the getter here? Or is it okay to use 'this' instead?
        FamilyRelation[] temp = new FamilyRelation[this.familyConnections.length +1];
        for (int i = 0; i < this.familyConnections.length; i++){
            temp[i] = this.familyConnections[i];
        }
        temp[this.familyConnections.length] = record;
        this.setFamilyConnections(temp);
    }
    public void removeFamilyConnection(FamilyRelation exRelation){
        FamilyRelation[] temp = new FamilyRelation[familyConnections.length -1];
        for (int i = 0; i < this.familyConnections.length; i++){
            if (this.familyConnections[i] != exRelation){
                temp[i] = this.familyConnections[i];
            }
        }
        this.setFamilyConnections(temp);
    }

    public MedicalRecord[] getMedicalRecords(){
        return this.medicalRecords;
    }
    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
    public void addMedicalRecord(MedicalRecord record){
        // NOTE: Should I be using the getter here? Or is it okay to use 'this' instead?
        MedicalRecord[] temp = new MedicalRecord[this.medicalRecords.length +1];
        for (int i = 0; i < this.medicalRecords.length; i++){
            temp[i] = this.medicalRecords[i];
        }
        temp[this.medicalRecords.length] = record;
        this.setMedicalRecords(temp);
    }

    public Supply[] getPersonalBelongings(){
        return this.personalBelongings;
    }
    public void setPersonalBelongings(Supply[] belongings){
        this.personalBelongings = belongings;
    }
    public void addPersonalBelonging(Supply supply){
        // NOTE: Should I be using the getter here? Or is it okay to use 'this' instead?
        Supply[] temp = new Supply[this.personalBelongings.length +1];
        for (int i = 0; i < this.personalBelongings.length; i++){
            temp[i] = this.personalBelongings[i];
        }
        temp[this.personalBelongings.length] = supply;
        this.setPersonalBelongings(temp);
    }
    public void removePersonalBelonging(Supply unwantedSupply){
        Supply[] temp = new Supply[this.personalBelongings.length -1];
        for (int i = 0; i < this.personalBelongings.length; i++){
            if (this.personalBelongings[i] != unwantedSupply){
                temp[i] = this.personalBelongings[i];
            }
        }
        this.setPersonalBelongings(temp);
    }

    public String getEntryDate(){
        return this.ENTRY_DATE;
    }

    public String getComments(){
        return this.comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }

    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    private static int generateSocialID(){
        // NOTE: There is no guideline to what the SocialID should be.
        // I just assigned the current value of counter to it.
        return counter;
    }

    private static boolean isValidDateFormat(String date){
        // Identical to the one in MedicalRecord
        Pattern dateFormat = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");  // Only allowing the YYYY-MM-DD format
        Matcher myMatcher = dateFormat.matcher(date);
        return myMatcher.matches();
    }

    private int convertDateStringToInt(String dateStr){
        // Note: assumes the date follows the correct format (YYYY-MM-DD)
        // NOTE: NOT IMPLEMENTED YET!
        String[] str = dateStr.split("-", 0);
        return 1;
    }
}
