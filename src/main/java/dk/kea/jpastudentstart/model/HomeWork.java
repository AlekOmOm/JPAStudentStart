package dk.kea.jpastudentstart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;


import java.time.*;

@Entity
public class HomeWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int homeWorkID;

    @Column(unique = true)
    private String title;
    private String subject;

    public HomeWork (String title, String subject) {
        this.title = title;
        this.subject = subject;
    }

    public HomeWork() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
