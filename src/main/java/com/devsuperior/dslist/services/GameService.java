package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

  @Autowired
  private GameRepository ganGameRepository;

  @Transactional(readOnly = true)
  public GameDTO findById(Long id){
    Game result = ganGameRepository.findById(id).get();
    GameDTO dto = new GameDTO(result);
    return dto;
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    // listando os games pegando no banco de dados
    List<Game> result = ganGameRepository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
  }

}
