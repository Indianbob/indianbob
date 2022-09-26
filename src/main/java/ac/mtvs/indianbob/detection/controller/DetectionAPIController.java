package ac.mtvs.indianbob.detection.controller;

import ac.mtvs.indianbob.detection.model.dto.DetectionInfoResponse;
import ac.mtvs.indianbob.detection.model.dto.DetectionDTO;
import ac.mtvs.indianbob.detection.model.service.DetectionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detection")
public class DetectionAPIController {

    private final DetectionService detectionService;

    @Autowired
    public DetectionAPIController(DetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @PostMapping("/info")
    public DetectionInfoResponse detectionInfoAPI(HttpServletRequest resquest) throws IOException {

        JSONObject resData = new JSONObject(resquest.getReader().lines().collect(Collectors.joining(System.lineSeparator())).toString());
        System.out.println(resquest.getReader().lines().collect(Collectors.joining(System.lineSeparator())).toString());
        DetectionInfoResponse detectionInfoResponse = new DetectionInfoResponse();

        //System.out.println("Request Info : " + resData);

        int patientId = Integer.parseInt(resData.getString("id"));
        String patientName = resData.getString("name");
        String cameraNumber = resData.getString("camera_number");
        String detectionTime = resData.getString("time");
        String detectionImage = resData.getJSONObject("image").getString("img");

        System.out.println("patientName : " + patientId);
        System.out.println("patientName : " + patientName);
        System.out.println("cameraNumber : " + cameraNumber);
        System.out.println("detectionTime : " + detectionTime);
        System.out.println("detectionImage : " + detectionImage);

        // 인코딩된 base64 값을 디코딩
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodeBytes = decoder.decode(detectionImage);

        //System.out.println(new String(decodeBytes));

        // 파일로 저장
        File file = null;
        String filePath = "D:\\indianbob\\indianbob\\src\\main\\resources\\static\\images\\detection";
        File dir = new File(filePath);
        if(!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }

        BufferedOutputStream bos = null;
        FileOutputStream fos = null;

        // 파일명 탐지 코드 DB 가져와서 정하기
        int recentDetectionCode =  detectionService.selectRecentDetectionInfo(patientId).getDetectionCode();

        try {
            // 파일명 : detection + (탐지코드 + 1) + .png
            String fileName = "\\detection" + (recentDetectionCode + 1) + ".png";
            file = new File(filePath + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(decodeBytes);

            DetectionDTO detectionInfo = new DetectionDTO();
            detectionInfo.setDetectionLocation(cameraNumber);
            detectionInfo.setDetectionDate(detectionTime);
            detectionInfo.setPatientCode(patientId);
            detectionInfo.setImagePath(filePath);
            detectionInfo.setImageName(fileName);

            System.out.println(detectionInfo);
            detectionService.insertDetectionInfo(detectionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        detectionInfoResponse.setHttpStatusCode(200);
        detectionInfoResponse.setMessage("successfully request completed");

        return detectionInfoResponse;
    }

    @GetMapping("/aa")
    public String example() {

        int patientId = 1;
        DetectionDTO recentDetectionInfo = detectionService.selectRecentDetectionInfo(patientId);

        System.out.println(recentDetectionInfo);

        return "Hello World";
    }
}
