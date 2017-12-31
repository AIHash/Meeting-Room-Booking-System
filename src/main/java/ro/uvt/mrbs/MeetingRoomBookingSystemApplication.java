package ro.uvt.mrbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "ro.uvt.mrbs")
@PropertySource(value = "classpath:application.yaml")
@PropertySource(value = "classpath:applicationDB.properties")
public class MeetingRoomBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingRoomBookingSystemApplication.class, args);
    }
}
