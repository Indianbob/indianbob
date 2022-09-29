package ac.mtvs.indianbob.detection.model.dao;

import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import ac.mtvs.indianbob.detection.model.dto.DetectionPatientDTO;
import ac.mtvs.indianbob.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetectionMapper {

    List<DetectionDTO> selectAllDetection();

    List<DetectionPatientDTO> selectAllDetectionPatient();

    DetectionDTO selectRecentDetectionInfo(int patientId);

    boolean insertDetectionInfo(DetectionDTO detectionInfo);

    List<DetectionDTO> selectDetectionByPatientCode(int patientCode);

    DetectionDTO selectRecentDetectionByPatientCode(int patientCode);

    List<DetectionPatientDTO> selectPagenationDetectionPatient(SelectCriteria selectCriteria);
}
