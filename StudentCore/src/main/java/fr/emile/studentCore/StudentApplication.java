package fr.emile.studentCore;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentApplication {
    public StudentApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}
