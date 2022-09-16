package kr.co.wcfcb.we_can_find_can_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WeCanFindCanBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeCanFindCanBackendApplication.class, args);
    }

}
