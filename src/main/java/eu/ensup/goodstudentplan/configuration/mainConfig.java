package eu.ensup.goodstudentplan.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mainConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
