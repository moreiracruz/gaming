package br.com.alura.gaming.restapi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.gaming.enums.TypeEnum;
import br.com.alura.gaming.service.GamingService;

@RestController
@RequestMapping("/gaming")
public class GamingController {

	@Autowired
	private GamingService gamingService;
	
	@PostMapping(path = "/{user}/{type}")
	public ResponseEntity<?> save(@PathVariable("user") final UUID user, @PathVariable("type") final String type) {
		gamingService.save(user, type);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/{user}")
	public ResponseEntity<Long> getByUser(@PathVariable("user") final UUID user) {
		return ResponseEntity.ok(this.gamingService.getPointsByUser(user));
	}
	
	@GetMapping(path = "/{user}/{type}")
	public ResponseEntity<Long> getByUserAndType(@PathVariable("user") final UUID user, @PathVariable("type") final String type) {
		TypeEnum typeEnum = TypeEnum.valueOf(type);
		return ResponseEntity.ok(this.gamingService.getPointsByUserAndType(user, typeEnum));
	}
	
	
	
}
