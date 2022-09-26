package ac.mtvs.indianbob.detection.model.dao;

import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetectionMapper {
    DetectionDTO selectRecentDetectionInfo(int patientId);

    boolean insertDetectionInfo(DetectionDTO detectionInfo);

    DetectionDTO selectDetectionByPatientCode(int patientCode);
}
