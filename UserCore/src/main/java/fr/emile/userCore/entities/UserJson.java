package fr.emile.userCore.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJson {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
}
