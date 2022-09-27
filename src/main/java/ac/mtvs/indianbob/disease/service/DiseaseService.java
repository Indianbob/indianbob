package ac.mtvs.indianbob.disease.service;

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
}
