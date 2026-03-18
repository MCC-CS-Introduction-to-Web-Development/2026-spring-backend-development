package edu.mcc.codeschool.class19.services;

import edu.mcc.codeschool.class19.clients.PokemonCardClient;
import edu.mcc.codeschool.class19.mappers.PokemonMapper;
import edu.mcc.codeschool.class19.models.Pokemon;
import edu.mcc.codeschool.class19.models.external.PokemonCard;
import edu.mcc.codeschool.class19.models.external.PokemonDataResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonCardService {
    private final PokemonCardClient pokemonCardClient;
    private final PokemonMapper pokemonMapper;

    public PokemonCardService(PokemonCardClient pokemonCardClient, PokemonMapper pokemonMapper) {
        this.pokemonCardClient = pokemonCardClient;
        this.pokemonMapper = pokemonMapper;
    }

    public List<Pokemon> listPokemonCards(){
        PokemonDataResponse resp = pokemonCardClient.listPokemonCards();
        List<PokemonCard> data = resp.getData() != null ? resp.getData() : null;
        List<Pokemon> ret = new ArrayList<>();
        data.forEach(card -> ret.add(pokemonMapper.mapPokemon(card)));
        return ret;
    }
}
