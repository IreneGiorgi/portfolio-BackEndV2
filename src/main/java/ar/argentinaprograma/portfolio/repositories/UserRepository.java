package ar.argentinaprograma.portfolio.repositories;

import ar.argentinaprograma.portfolio.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository <User, Long> {

	List<User> findByUser(String user);
	
}
