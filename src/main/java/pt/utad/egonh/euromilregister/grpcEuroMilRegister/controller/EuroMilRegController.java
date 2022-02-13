package pt.utad.egonh.euromilregister.grpcEuroMilRegister.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pt.utad.egonh.euromilregister.grpcEuroMilRegister.model.Bet;
import pt.utad.egonh.euromilregister.grpcEuroMilRegister.service.EuroMilRegService;

@RestController
public class EuroMilRegController {

	@Autowired
	private EuroMilRegService emrs;

	@PostMapping("/")
	public ResponseEntity<String> registerBet(@RequestBody Bet bet) {
		String result = emrs.registerEuroMil(bet.getKeyGame(), bet.getCheckId());
		if (StringUtils.isBlank(result)) {
			System.out.println("result -> " +result);
			return new ResponseEntity<String>(result,HttpStatus.PAYMENT_REQUIRED);
		}
		String JsonResult = "{\"result\":\"%s\"}".formatted(result);
		System.out.println("result -> " +JsonResult);
		return new ResponseEntity<String>(JsonResult,HttpStatus.ACCEPTED);
	}
	
}
