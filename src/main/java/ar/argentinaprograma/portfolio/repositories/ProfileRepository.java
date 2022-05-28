package ar.argentinaprograma.portfolio.repositories;

import ar.argentinaprograma.portfolio.models.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository <Profile, Long> {

}
