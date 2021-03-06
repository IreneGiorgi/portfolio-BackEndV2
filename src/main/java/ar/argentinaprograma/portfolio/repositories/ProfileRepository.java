package ar.argentinaprograma.portfolio.repositories;

import ar.argentinaprograma.portfolio.models.Profile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ProfileRepository extends JpaRepository <Profile, Long> {

	
}
