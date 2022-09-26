package ac.mtvs.indianbob.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages ="ac.mtvs.indianbob", annotationClass = Mapper.class)
public class MybatisConfig {
}
