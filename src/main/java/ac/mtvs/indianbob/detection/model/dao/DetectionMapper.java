package ac.mtvs.indianbob.detection.model.dao;

import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;

public interface DetectionMapper {
    DetectionDTO selectRecentDetectionInfo();
}
