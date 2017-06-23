package isamrs.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import isamrs.rest.domain.Reservation;
import isamrs.rest.service.ReservationService;

@RestController
public class ReservationController {
	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(
			value = "/api/reservations",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Reservation>> getReservation() throws Exception{
		logger.info(">>> Getting reservation");
		Page<Reservation> retVal = this.reservationService.findAll();
		HttpStatus status = HttpStatus.OK; 
		logger.info("<<< Getting reservation");
		return new ResponseEntity<Page<Reservation>>(retVal, status);
	}
	
	@RequestMapping(
			value = "/api/reservation",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) throws Exception{
		logger.info(">>> Creating system manager");
		Reservation retVal = this.reservationService.create(reservation);
		HttpStatus status = null;
		if(retVal != null){
			logger.info("==> Reservation created!");
			status = HttpStatus.CREATED;
		}else{
			logger.info("==> Reservation not created!");
			//PROVERI KOJI STATUS IDE KAD JE DODAVANJE NEUSPESNO
			status = HttpStatus.OK; 
		}
		logger.info(">>> Creating reservation");
		return new ResponseEntity<Reservation>(retVal, status);
	}

}
