package ro.fasttrackit.curs23jpa.repository;

import org.springframework.data.repository.CrudRepository;
import ro.fasttrackit.curs23jpa.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
