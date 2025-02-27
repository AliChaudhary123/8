package edu.ucalgary.oop;

import java.util.Arrays;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

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
        if (isValidDateFormat((ENTRY_DATE))){
            this.ENTRY_DATE = ENTRY_DATE;
        }
        else {
            throw new IllegalArgumentException();
        }
        counter++;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.familyConnections = new FamilyRelation[1];
        this.medicalRecords = new MedicalRecord[1];
        this.personalBelongings = new Supply[1];
    }
    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) throws IllegalArgumentException{
        this.firstName = firstName;
        if (isValidDateFormat(dateOfBirth) && isValidDateFormat(ENTRY_DATE) && (convertDateStringToInt(dateOfBirth) < convertDateStringToInt(ENTRY_DATE))) {
            this.dateOfBirth = dateOfBirth;
            this.ENTRY_DATE = ENTRY_DATE;
        }
        else{
            throw new IllegalArgumentException();
        }
        counter++;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.familyConnections = new FamilyRelation[1];
        this.medicalRecords = new MedicalRecord[1];
        this.personalBelongings = new Supply[1];
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
        List<FamilyRelation> src = new ArrayList<>(Arrays.asList(this.getFamilyConnections()));
        src.add(record);
        FamilyRelation[] updated = src.toArray(new FamilyRelation[src.toArray().length]);
        this.setFamilyConnections(updated);
    }
    public void removeFamilyConnection(FamilyRelation exRelation){
        List<FamilyRelation> src = new ArrayList<>(Arrays.asList(this.getFamilyConnections()));
        src.remove(exRelation);
        FamilyRelation[] updated = src.toArray(new FamilyRelation[src.toArray().length]);
        this.setFamilyConnections(updated);
    }

    public MedicalRecord[] getMedicalRecords(){
        return this.medicalRecords;
    }
    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
    public void addMedicalRecord(MedicalRecord record){
        List<MedicalRecord> src = new ArrayList<>(Arrays.asList(this.getMedicalRecords()));
        src.add(record);
        MedicalRecord[] updated = src.toArray(new MedicalRecord[src.toArray().length]);
        this.setMedicalRecords(updated);
    }

    public Supply[] getPersonalBelongings(){
        return this.personalBelongings;
    }
    public void setPersonalBelongings(Supply[] belongings){
        this.personalBelongings = belongings;
    }
    public void addPersonalBelonging(Supply supply){
        List<Supply> src = new ArrayList<>(Arrays.asList(this.getPersonalBelongings()));
        src.add(supply);
        Supply[] updated = src.toArray(new Supply[src.toArray().length]);
        this.setPersonalBelongings(updated);
    }
    public void removePersonalBelonging(Supply unwantedSupply){
        List<Supply> src = new ArrayList<>(Arrays.asList(this.getPersonalBelongings()));
        src.remove(unwantedSupply);
        Supply[] updated = src.toArray(new Supply[src.toArray().length]);
        this.setPersonalBelongings(updated);
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
        String newStr = str[0]+str[1]+str[2];
        int dateAsInt = Integer.parseInt(newStr);
        
        return dateAsInt;
    }
}
