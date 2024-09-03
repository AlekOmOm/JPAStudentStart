package dk.kea.jpastudentstart.model;

import jakarta.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectID;
    @Column(unique = true)
    private String name;
    private int ects;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Subject() {
    }

    public Subject(String name, int ects) {
        this.name = name;
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public int getEcts() {
        return ects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
