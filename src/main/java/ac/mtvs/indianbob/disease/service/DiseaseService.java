package ac.mtvs.indianbob.disease.service;

import ac.mtvs.indianbob.common.exception.disease.DiseaseRegistException;
import ac.mtvs.indianbob.disease.dao.DiseaseMapper;
import ac.mtvs.indianbob.disease.dto.DiseaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseMapper mapper;

    private DiseaseService(DiseaseMapper mapper) {this.mapper = mapper;}


    public List<DiseaseDTO> selectAllDiseaseList() {
        List<DiseaseDTO> diseaseList = mapper.selectAllDiseaseList();

        return diseaseList;
    }

    public void registDisease(DiseaseDTO disease) throws DiseaseRegistException {
        int result = mapper.insertDisease(disease);

        if(!(result > 0)) {
            throw new DiseaseRegistException("질병 등록에 실패하셨습니다.");
        }
    }
}
