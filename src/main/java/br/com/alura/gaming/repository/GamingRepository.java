package br.com.alura.gaming.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.gaming.entity.Gamefication;
import br.com.alura.gaming.enums.TypeEnum;

@Repository
public interface GamingRepository extends JpaRepository<Gamefication, UUID>{

	List<Gamefication> findByUser(UUID user);
	List<Gamefication> findByUserAndPoint_Type(UUID user, TypeEnum type);
}
