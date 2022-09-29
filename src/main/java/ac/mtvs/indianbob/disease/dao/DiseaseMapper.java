package ac.mtvs.indianbob.disease.dao;

import ac.mtvs.indianbob.disease.dto.DiseaseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiseaseMapper {
    List<DiseaseDTO> selectAllDiseaseList();

    int insertDisease(DiseaseDTO disease);

    int incrementDiseaseCount(Long no);

    DiseaseDTO selectDiseaseDetail(Long no);

    int updateDisease(DiseaseDTO disease);

    int deleteDisease(Long no);
}
