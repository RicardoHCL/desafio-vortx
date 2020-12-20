package br.com.vortx.vxtel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vortx.vxtel.models.Tariff;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

	Optional<Tariff> findByOriginAndDestiny(Integer origin, Integer destiny);
}
