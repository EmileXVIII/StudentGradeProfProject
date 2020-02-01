package fr.emile.todoCore;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TotosApplication {
    public TotosApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(TotosApplication.class, args);
    }
}
