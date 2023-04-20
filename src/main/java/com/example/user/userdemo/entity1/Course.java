package com.example.user.userdemo.entity1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course1", schema = "appconfig")
public class Course {
    @Id
    private int id;
    private String name;
    private int price;
}
