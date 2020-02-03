package fr.emile.gradeCore;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GradeApplication {
    public GradeApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GradeApplication.class, args);
    }
}
