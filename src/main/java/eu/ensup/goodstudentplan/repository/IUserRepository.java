package eu.ensup.goodstudentplan.repository;

import eu.ensup.goodstudentplan.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {

}
