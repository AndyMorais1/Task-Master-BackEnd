package com.taskmaster.taskmaster.model;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username", unique=true, nullable=false, length=255)
    private String username;

    @Column(name ="email", unique=true, nullable=false, length=255)
    private String email;

    @Column(name="password", nullable=false, length=255)
    private String password;


    //tipo de usuario

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable=false, length=25)
    private Role role;

    //sistema de auditoria

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    @Column(name = "create_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;


    public enum Role {
        ROLE_CLIENT, ROLE_ADMIN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
