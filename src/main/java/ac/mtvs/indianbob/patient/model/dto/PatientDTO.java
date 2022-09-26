package ac.mtvs.indianbob.patient.model.dto;

public class PatientDTO {

    private int num;
    private String name;
    private String birth;
    private String disease;
    private String gender;

    public PatientDTO() {};

    public PatientDTO(int num, String name, String birth, String disease, String gender) {
        this.num = num;
        this.name = name;
        this.birth = birth;
        this.disease = disease;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", disease='" + disease + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

