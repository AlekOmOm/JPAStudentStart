package dk.kea.jpastudentstart.repository;

import dk.kea.jpastudentstart.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeWorkRepository extends JpaRepository<HomeWork, Integer> {
    HomeWork findByTitle(String title);
}
