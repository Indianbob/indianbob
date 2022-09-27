package ac.mtvs.indianbob.disease.dao;

import ac.mtvs.indianbob.disease.dto.DiseaseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiseaseMapper {
    List<DiseaseDTO> selectAllDiseaseList();
}
