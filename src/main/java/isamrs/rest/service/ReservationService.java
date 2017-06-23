package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import isamrs.rest.domain.Reservation;
import isamrs.rest.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Page<Reservation> findAll() {
		return reservationRepository.findAll(null);
		
	}

	public Reservation create(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
}
