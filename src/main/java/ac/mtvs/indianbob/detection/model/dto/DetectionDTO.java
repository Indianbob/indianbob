package ac.mtvs.indianbob.detection.model.dto;

import java.util.Arrays;


public class DetectionDTO {
    private int detectionCode;
    private String detectionDate;
    private String detectionLocation;
    private int patientCode;
    private String imagePath;
    private String imageName;
    private byte[] image;

    public DetectionDTO() {
    }

    public DetectionDTO(int detectionCode, String detectionDate, String detectionLocation, int patientCode, String imagePath, String imageName, byte[] image) {
        this.detectionCode = detectionCode;
        this.detectionDate = detectionDate;
        this.detectionLocation = detectionLocation;
        this.patientCode = patientCode;
        this.imagePath = imagePath;
        this.imageName = imageName;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DetectionDTO{" +
                "detectionCode=" + detectionCode +
                ", detectionDate='" + detectionDate + '\'' +
                ", detectionLocation='" + detectionLocation + '\'' +
                ", patientCode=" + patientCode +
                ", imagePath='" + imagePath + '\'' +
                ", imageName='" + imageName + '\'' +
                ", image=" + Arrays.toString(image).getBytes() +
                '}';
    }
}