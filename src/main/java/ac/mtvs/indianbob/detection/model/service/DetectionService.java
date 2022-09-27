package ac.mtvs.indianbob.detection.model.service;

import ac.mtvs.indianbob.detection.model.dao.DetectionMapper;
import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import ac.mtvs.indianbob.detection.model.dto.DetectionPatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetectionService {

    private DetectionMapper detectionMapper;

    @Autowired
    public DetectionService(DetectionMapper detectionMapper) {
        this.detectionMapper = detectionMapper;
    }

    public List<DetectionDTO> selectAllDetection() {

        return detectionMapper.selectAllDetection();
    }

    public List<DetectionPatientDTO> selectAllDetectionPatient() {

        return detectionMapper.selectAllDetectionPatient();
    }

    public DetectionDTO selectRecentDetectionInfo(int patientId) {

        return detectionMapper.selectRecentDetectionInfo(patientId);
    }

    public List<DetectionDTO> selectDetectionByPatientCode(int patientCode) {

        return detectionMapper.selectDetectionByPatientCode(patientCode);
    }

    @Transactional
    public boolean insertDetectionInfo(DetectionDTO detectionInfo) {

        return detectionMapper.insertDetectionInfo(detectionInfo);
    }

    public DetectionDTO selectRecentDetectionByPatientCode(int patientCode) {

        return detectionMapper.selectRecentDetectionByPatientCode(patientCode);
    }
}
