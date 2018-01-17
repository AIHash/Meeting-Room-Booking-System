package ro.uvt.mrbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "ro.uvt.mrbs")
@PropertySource(value = "classpath:application.yaml")
@PropertySource(value = "classpath:applicationDB.properties")
@PropertySource(value = "classpath:emailer.properties")
public class MeetingRoomBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingRoomBookingSystemApplication.class, args);
    }
}
