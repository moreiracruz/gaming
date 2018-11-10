package br.com.alura.gaming.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.gaming.entity.Gamefication;
import br.com.alura.gaming.entity.Point;
import br.com.alura.gaming.enums.TypeEnum;
import br.com.alura.gaming.repository.GamingRepository;

@Service
public class GamingService {

	@Autowired
	private GamingRepository gamingRepository;
	
	public void save(UUID user, String type) {
		
		Point point = new Point(TypeEnum.valueOf(type));
		Gamefication gamfication = new Gamefication(user, point);
		gamingRepository.save(gamfication);
	}
	
	public Long getPointsByUser(UUID user){
		List<Gamefication> gameficationList = this.gamingRepository.findByUser(user);
		
		return getSumOfValues(gameficationList);
	}

	public Long getPointsByUserAndType(UUID user, TypeEnum type){
		List<Gamefication> gameficationList = this.gamingRepository.findByUserAndPoint_Type(user, type);
		
		return getSumOfValues(gameficationList);
	}
	
	private long getSumOfValues(List<Gamefication> gameficationList) {
		return gameficationList.stream().mapToLong(g -> g.getPoint()).sum();
	}

}
