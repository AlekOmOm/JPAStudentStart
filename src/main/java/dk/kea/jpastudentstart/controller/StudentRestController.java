package dk.kea.jpastudentstart.controller;

import dk.kea.jpastudentstart.model.HomeWork;
import dk.kea.jpastudentstart.model.Student;
import dk.kea.jpastudentstart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/studentsJSON")
    public List<Student> getStudentsJSON() {

        return studentRepository.findAll();
    }
    @GetMapping("/students")
    public String getStudentsHTML(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "home";
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PostMapping("/students/add/{name}")
    public Student postStudent(@PathVariable String name) {
        Student student = new Student();
        student.setName(name);
        student.setBornDate(LocalDate.now());
        student.setBornTime(LocalTime.now());

        return studentRepository.save(student);
    }

    @PostMapping("/students/add/{name}/homeWork/{homeWorkTitle}")
    public Student postHomeWork(@PathVariable String name, @PathVariable String homeWorkTitle) {
        Student student = studentRepository.findByName(name);
        HomeWork homeWork = new HomeWork();
        homeWork.setTitle(homeWorkTitle);
        homeWork.setSubject("Math");
        student.setHomeWork(homeWork);

        return studentRepository.save(student);
    }


    @PutMapping("/students/update/{name}/{dob}")
    public Student putStudent(@PathVariable String name, @PathVariable String dob) {
        Student student = studentRepository.findByName(name);
        student.setBornDate(LocalDate.parse(dob));

        return studentRepository.save(student);
    }

    @DeleteMapping("/students/delete/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStudent(@PathVariable String name) {
        Student student = studentRepository.findByName(name);
        studentRepository.delete(student);

        return "Student deleted";
    }

}