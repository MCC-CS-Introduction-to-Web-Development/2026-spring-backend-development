package edu.mcc.codeschool.class19.controllers;

import edu.mcc.codeschool.class19.models.Pokemon;
import edu.mcc.codeschool.class19.services.PokemonCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class PokemonCardController {
    private final PokemonCardService pokemonCardService;

    public PokemonCardController(PokemonCardService pokemonCardService) {
        this.pokemonCardService = pokemonCardService;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> listPokemonCards(){
        return ResponseEntity.ok(pokemonCardService.listPokemonCards());
    }
}
