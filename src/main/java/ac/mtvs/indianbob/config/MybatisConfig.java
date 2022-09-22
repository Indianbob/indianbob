package ac.mtvs.indianbob.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "ac.mtvs.indianbob", annotationClass = Mapper.class)
public class MybatisConfig {
}
