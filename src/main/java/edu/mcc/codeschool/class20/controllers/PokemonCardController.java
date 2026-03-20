package edu.mcc.codeschool.class20.controllers;

import edu.mcc.codeschool.class20.models.Pokemon;
import edu.mcc.codeschool.class20.services.PokemonCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PokemonCardController {
    private final PokemonCardService pokemonCardService;

    public PokemonCardController(PokemonCardService pokemonCardService) {
        this.pokemonCardService = pokemonCardService;
    }

    @GetMapping("/v1/cards")
    public ResponseEntity<List<Pokemon>> listPokemonCards(){
        return ResponseEntity.ok(pokemonCardService.listPokemonCards());
    }

    @GetMapping("/v2/cards/{id}")
    public ResponseEntity<Pokemon> getPokemonCardById(@PathVariable String id){
        Pokemon resp = pokemonCardService.getPokemonById(id);
        return resp != null ? ResponseEntity.ok(resp) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
