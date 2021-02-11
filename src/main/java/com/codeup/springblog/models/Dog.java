package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="dogs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "reside_state"})
})

public class Dog {

    public Dog() {

    }

    public Dog(long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private int age;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(name = "reside_state", nullable = false, columnDefinition = "char(2)")
    private String resideState;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
