package ar.argentinaprograma.portfolio.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.argentinaprograma.portfolio.models.CardSection;


@Repository
public interface CardSectionRepository  extends JpaRepository <CardSection, UUID> {

}
