package ac.mtvs.indianbob.model.PatientApi;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class patientApi {
    public String patientCode;
    public String patientName;
    public String patientBirth;
    public String guardianPhone;
    public String guardianName;
    public String patientRelationship;
    public String patientAddress;
    public String patientPhone;
    public String patientPicture;
    public String explanation;
    public String entranceDate;
    public String exitDate;
    public String exitYN;
    public String manageStaffCode;
    public String patientGender;
}
