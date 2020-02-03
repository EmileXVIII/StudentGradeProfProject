package fr.emile.teacherCore;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TeacherApplication {
    public TeacherApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class, args);
    }
}
