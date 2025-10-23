package me.moteloff.assessment;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BeyonnexAssessmentApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BeyonnexAssessmentApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
