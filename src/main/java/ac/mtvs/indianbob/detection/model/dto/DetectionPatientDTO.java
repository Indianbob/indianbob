package ac.mtvs.indianbob.detection.model.dto;

import ac.mtvs.indianbob.member.dto.MemberDTO;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;

public class DetectionPatientDTO {
    private int detectionCode;
    private String detectionDate;
    private String detectionLocation;
    private int patientCode;
    private String imagePath;
    private String imageName;
    private PatientDTO patient;

    public DetectionPatientDTO() {
    }

    public DetectionPatientDTO(int detectionCode, String detectionDate, String detectionLocation, int patientCode, String imagePath, String imageName, PatientDTO patient) {
        this.detectionCode = detectionCode;
        this.detectionDate = detectionDate;
        this.detectionLocation = detectionLocation;
        this.patientCode = patientCode;
        this.imagePath = imagePath;
        this.imageName = imageName;
        this.patient = patient;
    }

    public int getDetectionCode() {
        return detectionCode;
    }

    public void setDetectionCode(int detectionCode) {
        this.detectionCode = detectionCode;
    }

    public String getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(String detectionDate) {
        this.detectionDate = detectionDate;
    }

    public String getDetectionLocation() {
        return detectionLocation;
    }

    public void setDetectionLocation(String detectionLocation) {
        this.detectionLocation = detectionLocation;
    }

    public int getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(int patientCode) {
        this.patientCode = patientCode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "DetectionPatientDTO{" +
                "detectionCode=" + detectionCode +
                ", detectionDate='" + detectionDate + '\'' +
                ", detectionLocation='" + detectionLocation + '\'' +
                ", patientCode=" + patientCode +
                ", imagePath='" + imagePath + '\'' +
                ", imageName='" + imageName + '\'' +
                ", patient=" + patient +
                '}';
    }
}
