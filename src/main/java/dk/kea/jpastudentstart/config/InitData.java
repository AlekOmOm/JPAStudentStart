package dk.kea.jpastudentstart.config;

import dk.kea.jpastudentstart.model.Student;
import dk.kea.jpastudentstart.model.HomeWork;
import dk.kea.jpastudentstart.repository.HomeWorkRepository;
import dk.kea.jpastudentstart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private HomeWorkRepository homeWorkRepository;

    Student[] students = new Student[]{
        new Student("Hans", LocalDate.of(2000, 1, 1), LocalTime.of(12, 0)),
        new Student("Viggo", LocalDate.of(2001, 2, 2), LocalTime.of(13, 0)),
        new Student("Bent", LocalDate.of(2002, 3, 3), LocalTime.of(14, 0)),
        new Student("Jens", LocalDate.of(2003, 4, 4), LocalTime.of(15, 0)),
        new Student("Finn", LocalDate.of(2004, 5, 5), LocalTime.of(16, 0)),
        new Student("Hanne", LocalDate.of(2005, 6, 6), LocalTime.of(17, 0)),
        new Student("Lone", LocalDate.of(2006, 7, 7), LocalTime.of(18, 0)),
        new Student("Lene", LocalDate.of(2007, 8, 8), LocalTime.of(19, 0)),
        new Student("Lise", LocalDate.of(2008, 9, 9), LocalTime.of(20, 0)),
        new Student("Lars", LocalDate.of(2009, 10, 10), LocalTime.of(21, 0))
    };

    HomeWork[] homeWorks = new HomeWork[] {
            new HomeWork("Math", "Math homework"),
            new HomeWork("English", "English homework"),
            new HomeWork("Literature", "Literature homework"),
            new HomeWork("History", "History homework"),
            new HomeWork("Physics", "Physics homework"),
            new HomeWork("Chemistry", "Chemistry homework"),
            new HomeWork("Biology", "Biology homework"),
            new HomeWork("Geography", "Geography homework"),
            new HomeWork("Music", "Music homework"),
            new HomeWork("Art", "Art homework")
    };


    @Override
    public void run(String... args) throws Exception {

        if (studentRepository.count() > 0) {
            return;
        }

        int i = 0;
        for (Student student : students) {
            HomeWork homeWork = homeWorkRepository.save(homeWorks[i]);
            student.setHomeWork(homeWorks[i]);
            i++;
        }

        studentRepository.saveAll(Arrays.asList(students));

    }
}
