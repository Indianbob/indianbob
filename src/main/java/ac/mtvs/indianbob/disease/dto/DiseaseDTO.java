package ac.mtvs.indianbob.disease.dto;

public class DiseaseDTO {
    private int illnessCode;         // 지병코드
    private String illnessName;      // 지병명

    public DiseaseDTO() {
    }

    public DiseaseDTO(int illnessCode, String illnessName) {
        this.illnessCode = illnessCode;
        this.illnessName = illnessName;
    }

    public int getIllnessCode() {
        return illnessCode;
    }

    public void setIllnessCode(int illnessCode) {
        this.illnessCode = illnessCode;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    @Override
    public String toString() {
        return "DiseaseDTO{" +
                "illnessCode=" + illnessCode +
                ", illnessName='" + illnessName + '\'' +
                '}';
    }
}
