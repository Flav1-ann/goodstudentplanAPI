package eu.ensup.goodstudentplan.repository;

import eu.ensup.goodstudentplan.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String s);
}
