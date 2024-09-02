package dk.kea.jpastudentstart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;


import java.time.*;
import java.util.List;

import dk.kea.jpastudentstart.model.HomeWork;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (unique = true)
    private String name;
    private LocalDate bornDate;
    private LocalTime bornTime;

    @OneToOne
    @JoinColumn(name = "home_workidfk", referencedColumnName = "homeWorkID", nullable = true)
    private HomeWork homeWork;

    public Student() {
    }

    public Student(String name, LocalDate dob, LocalTime tob) {
        this.name = name;
        this.bornDate = dob;
        this.bornTime = tob;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public LocalTime getBornTime() {
        return bornTime;
    }

    public void setBornTime(LocalTime bornTime) {
        this.bornTime = bornTime;
    }

    public HomeWork getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(HomeWork homeWork) {
        this.homeWork = homeWork;
    }

}
