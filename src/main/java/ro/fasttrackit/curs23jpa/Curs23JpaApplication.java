package ro.fasttrackit.curs23jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs23jpa.domain.Address;
import ro.fasttrackit.curs23jpa.domain.Person;
import ro.fasttrackit.curs23jpa.repository.AddressRepository;
import ro.fasttrackit.curs23jpa.repository.PersonRepository;

@SpringBootApplication
public class Curs23JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs23JpaApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(PersonRepository repo, AddressRepository addressRepository) {
        return args -> {
            final Address ad = new Address("Kogalniceanu", 32);
            addressRepository.save(ad);
            repo.save(new Person("Maria", 30, new Address("Kogalniceanu", 32)));
            repo.save(new Person("Ion", 33, new Address("Pasteur", 102)));
            repo.save(new Person("Mihai", 21, new Address("Adevarului", 132)));
            repo.save(new Person("Ioana", 44, new Address("Stefan cel Mare", 12)));
            repo.save(new Person("Dorel", 10, new Address("Victoriei", 2)));

            repo.findAll()
                    .forEach(System.out::println);
            System.out.println("My query! ");
            System.out.println(repo.myQuery());
            System.out.println(repo.myQuery(40));
            System.out.println(repo.findFirstByAgeGreaterThan(40));
        };
    }
}
