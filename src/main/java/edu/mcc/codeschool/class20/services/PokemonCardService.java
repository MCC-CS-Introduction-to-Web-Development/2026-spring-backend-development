package edu.mcc.codeschool.class20.services;

import edu.mcc.codeschool.class20.clients.PokemonCardClient;
import edu.mcc.codeschool.class20.clients.PokemonCardClientV2;
import edu.mcc.codeschool.class20.mappers.PokemonMapper;
import edu.mcc.codeschool.class20.models.Pokemon;
import edu.mcc.codeschool.class20.models.external.GetPokemonByIdDataResponse;
import edu.mcc.codeschool.class20.models.external.PokemonCard;
import edu.mcc.codeschool.class20.models.external.ListPokemonDataResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonCardService {
    private final PokemonCardClient pokemonCardClient;
    private final PokemonCardClientV2 pokemonCardClientV2;
    private final PokemonMapper pokemonMapper;

    public PokemonCardService(PokemonCardClient pokemonCardClient, PokemonCardClientV2 pokemonCardClientV2, PokemonMapper pokemonMapper) {
        this.pokemonCardClient = pokemonCardClient;
        this.pokemonCardClientV2 = pokemonCardClientV2;
        this.pokemonMapper = pokemonMapper;
    }

    public List<Pokemon> listPokemonCards(){
        ListPokemonDataResponse resp = pokemonCardClient.listPokemonCards();
        List<PokemonCard> data = resp.getData() != null ? resp.getData() : null;
        List<Pokemon> ret = new ArrayList<>();
        data.forEach(card -> ret.add(pokemonMapper.mapPokemon(card)));
        return ret;
    }

    public Pokemon getPokemonById(String id) {
        GetPokemonByIdDataResponse resp = pokemonCardClientV2.getPokemonCardById(id).block();
        Pokemon pokemon = null;
        if(resp != null && resp.getData() != null){
            pokemon = pokemonMapper.mapPokemon(resp.getData());
        }
        return pokemon;
    }
}
