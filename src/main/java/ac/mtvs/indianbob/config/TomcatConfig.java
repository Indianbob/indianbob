package ac.mtvs.indianbob.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TomcatConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
//        factory.setDocumentRoot(new File("D:/indianbob/indianbob/src/main/resources/static/")); // 동후
//        factory.setDocumentRoot(new File("C:\\Users\\HP\\Desktop\\indianbob3\\src\\main\\resources\\static")); // 지현
        factory.setDocumentRoot(new File("D:\\INDIANBOB\\Indian_Bob\\indianbob\\src\\main\\resources\\static")); // 용준
    }
}
