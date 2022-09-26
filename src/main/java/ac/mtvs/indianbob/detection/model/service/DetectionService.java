package ac.mtvs.indianbob.detection.model.service;

import ac.mtvs.indianbob.detection.model.dao.DetectionMapper;
import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import org.springframework.stereotype.Service;

@Service
public class DetectionService {

    private DetectionMapper detectionMapper;

    public DetectionService(DetectionMapper detectionMapper) {
        this.detectionMapper = detectionMapper;
    }

    public DetectionDTO selectRecentDetectionInfo() {

        return detectionMapper.selectRecentDetectionInfo();
    }
}
