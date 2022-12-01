package com.makeev.inside.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "author")
@Data @NoArgsConstructor
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String password;

    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL)
    private List<Message> messageList;

    public Author(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
