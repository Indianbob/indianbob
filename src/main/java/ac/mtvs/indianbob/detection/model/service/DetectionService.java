package ac.mtvs.indianbob.detection.model.service;

import ac.mtvs.indianbob.detection.model.dao.DetectionMapper;
import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetectionService {

    private DetectionMapper detectionMapper;

    @Autowired
    public DetectionService(DetectionMapper detectionMapper) {
        this.detectionMapper = detectionMapper;
    }

    public DetectionDTO selectRecentDetectionInfo(int patientId) {

        return detectionMapper.selectRecentDetectionInfo(patientId);
    }

    @Transactional
    public boolean insertDetectionInfo(DetectionDTO detectionInfo) {

        return detectionMapper.insertDetectionInfo(detectionInfo);
    }
}
