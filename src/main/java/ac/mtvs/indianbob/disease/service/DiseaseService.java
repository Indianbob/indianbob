package ac.mtvs.indianbob.disease.service;

import ac.mtvs.indianbob.common.exception.disease.DiseaseModifyException;
import ac.mtvs.indianbob.common.exception.disease.DiseaseRegistException;
import ac.mtvs.indianbob.common.exception.disease.DiseaseRemoveException;
import ac.mtvs.indianbob.disease.dao.DiseaseMapper;
import ac.mtvs.indianbob.disease.dto.DiseaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseMapper mapper;

    @Autowired
    public DiseaseService(DiseaseMapper mapper) {
        this.mapper = mapper;
    }


    public List<DiseaseDTO> selectAllDiseaseList() {
        List<DiseaseDTO> diseaseList = mapper.selectAllDiseaseList();

        return diseaseList;
    }

    @Transactional
    public void registDisease(DiseaseDTO disease) throws DiseaseRegistException {
        int result = mapper.insertDisease(disease);

        if(!(result > 0)) {
            throw new DiseaseRegistException("질병 등록에 실패하셨습니다.");
        }
    }

    public DiseaseDTO selectDiseaseDetail(Long no) {
        DiseaseDTO diseaseDetail = null;

        diseaseDetail = mapper.selectDiseaseDetail(no);

        return diseaseDetail;
    }

    @Transactional
    public void modifyDisease(DiseaseDTO disease) throws DiseaseModifyException {
        int result = mapper.updateDisease(disease);

        if(!(result > 0)) {
            throw new DiseaseModifyException("공지사항 수정에 실패하셨습니다.");
        }
    }

    @Transactional
    public void removeDisease(Long no) throws DiseaseRemoveException {
        int result = mapper.deleteDisease(no);

        if(!(result > 0)) {
            throw new DiseaseRemoveException("공지사항 삭제에 실패하셨습니다.");
        }

    }
}
