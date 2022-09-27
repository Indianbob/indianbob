package ac.mtvs.indianbob.patient.model.dto;

public class PatientApiDTO {
    private int patientCode;
    private String patientName;
    private String patientPicture;

    public PatientApiDTO() {};

    public PatientApiDTO(int patientCode, String patientName, String patientPicture) {
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.patientPicture = patientPicture;
    }

    @Override
    public String toString() {
        return "PatientApiDTO{" +
                "patientCode=" + patientCode +
                ", patientName='" + patientName + '\'' +
                ", patientPicture='" + patientPicture + '\'' +
                '}';
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

    public String getPatientPicture() {
        return patientPicture;
    }

    public void setPatientPicture(String patientPicture) {
        this.patientPicture = patientPicture;
    }
}
