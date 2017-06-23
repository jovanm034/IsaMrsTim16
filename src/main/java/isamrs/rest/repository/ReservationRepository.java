package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import isamrs.rest.domain.Reservation;

public interface ReservationRepository extends Repository<Reservation, Long> {
	
	public Page<Reservation> findAll(Pageable pageable);
	public Reservation save(Reservation reservation);
}
