package ac.mtvs.indianbob.patient.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class PatientDTO {
    private int patientCode;
    private String patientName;
    private String patientBirth;
    private String guardianPhone;
    private String guardianName;
    private String patientRelationship;
    private String patientAddress;
    private String patientPhone;
    private String patientPicture;
    private String explanation;
    private String entranceDate;
    private String exitDate;
    private String exitYn;
    private int manageStaffCode;
    private String patientGender;

    public PatientDTO() {};

    public PatientDTO(int patientCode, String patientName, String patientBirth, String guardianPhone, String guardianName, String patientRelationship, String patientAddress, String patientPhone, String patientPicture, String explanation, String entranceDate, String exitDate, String exitYn, int manageStaffCode, String patientGender) {
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.patientBirth = patientBirth;
        this.guardianPhone = guardianPhone;
        this.guardianName = guardianName;
        this.patientRelationship = patientRelationship;
        this.patientAddress = patientAddress;
        this.patientPhone = patientPhone;
        this.patientPicture = patientPicture;
        this.explanation = explanation;
        this.entranceDate = entranceDate;
        this.exitDate = exitDate;
        this.exitYn = exitYn;
        this.manageStaffCode = manageStaffCode;
        this.patientGender = patientGender;
    }

    public int getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(int patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(String patientBirth) {
        this.patientBirth = patientBirth;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getPatientRelationship() {
        return patientRelationship;
    }

    public void setPatientRelationship(String patientRelationship) {
        this.patientRelationship = patientRelationship;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientPicture() {
        return patientPicture;
    }

    public void setPatientPicture(String patientPicture) {
        this.patientPicture = patientPicture;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = entranceDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public String getExitYn() {
        return exitYn;
    }

    public void setExitYn(String exitYn) {
        this.exitYn = exitYn;
    }

    public int getManageStaffCode() {
        return manageStaffCode;
    }

    public void setManageStaffCode(int manageStaffCode) {
        this.manageStaffCode = manageStaffCode;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "patientCode=" + patientCode +
                ", patientName='" + patientName + '\'' +
                ", patientBirth='" + patientBirth + '\'' +
                ", guardianPhone='" + guardianPhone + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", patientRelationship='" + patientRelationship + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientPicture='" + patientPicture + '\'' +
                ", explanation='" + explanation + '\'' +
                ", entranceDate='" + entranceDate + '\'' +
                ", exitDate='" + exitDate + '\'' +
                ", exitYn='" + exitYn + '\'' +
                ", manageStaffCode=" + manageStaffCode +
                ", patientGender='" + patientGender + '\'' +
                '}';
    }
}