package ac.mtvs.indianbob.detection.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetectionInfoResponse {
    private int httpStatusCode;
    private String message;
}