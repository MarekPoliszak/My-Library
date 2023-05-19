package com.poliszak.marek.my_library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
@EqualsAndHashCode(of = "id")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String regon;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    @JsonBackReference
    private Set<Book> books = new HashSet<>();
}

