package ac.mtvs.indianbob.detection.controller;

import ac.mtvs.indianbob.detection.model.dto.DetectionInfoResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Base64;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detection")
public class DetectionAPIController {

    @PostMapping ("/info")
    public DetectionInfoResponse detectionInfoAPI(HttpServletRequest resquest) throws IOException {

        JSONObject resData = new JSONObject(resquest.getReader().lines().collect(Collectors.joining(System.lineSeparator())).toString());
        System.out.println(resquest.getReader().lines().collect(Collectors.joining(System.lineSeparator())).toString());
        DetectionInfoResponse detectionInfoResponse = new DetectionInfoResponse();

        //System.out.println("Request Info : " + resData);

        String patientName = resData.getString("name");
        String cameraNumber = resData.getString("camera_number");
        String detectionTime = resData.getString("time");
        String detectionImage = resData.getJSONObject("image").getString("img");

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
        try {
            file = new File(filePath + "\\test03.png");
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(decodeBytes);
            
            // 파일경로 등 탐지로그 테이블에 저장하기(insert)
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
}
