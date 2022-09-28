package ac.mtvs.indianbob.disease.dto;

public class DiseaseDTO {
    private int illnessCode;         // 지병코드
    private String illnessName;      // 지병명
    private String illnessDesc;      // 지병 설명

    public DiseaseDTO() {
    }

    public DiseaseDTO(int illnessCode, String illnessName, String illnessDesc) {
        this.illnessCode = illnessCode;
        this.illnessName = illnessName;
        this.illnessDesc = illnessDesc;
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

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc;
    }

    @Override
    public String toString() {
        return "DiseaseDTO{" +
                "illnessCode=" + illnessCode +
                ", illnessName='" + illnessName + '\'' +
                ", illnessDesc='" + illnessDesc + '\'' +
                '}';
    }
}
