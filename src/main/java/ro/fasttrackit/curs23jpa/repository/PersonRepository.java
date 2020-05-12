package ro.fasttrackit.curs23jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrackit.curs23jpa.domain.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);

    Person findFirstByAgeGreaterThan(int age);

    @Query(value = "SELECT TOP 1 * FROM person WHERE age>10", nativeQuery = true)
    Person myQuery();

    @Query(value = "SELECT TOP 1 * FROM person WHERE age>?", nativeQuery = true)
    Person myQuery(int age);
}
