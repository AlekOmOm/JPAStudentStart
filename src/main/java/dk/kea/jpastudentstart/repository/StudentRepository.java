package dk.kea.jpastudentstart.repository;

import dk.kea.jpastudentstart.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    Student findByName(String name);
}
