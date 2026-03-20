package edu.mcc.codeschool.class20.clients;

import edu.mcc.codeschool.class20.config.PokemonClientConfig;
import edu.mcc.codeschool.class20.models.external.ListPokemonDataResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonCardClient {
    private final RestTemplate restTemplate;
    private final PokemonClientConfig pokemonClientConfig;


    public PokemonCardClient(RestTemplate restTemplate, PokemonClientConfig pokemonClientConfig) {
        this.restTemplate = restTemplate;
        this.pokemonClientConfig = pokemonClientConfig;
    }

    public ListPokemonDataResponse listPokemonCards(){
        return restTemplate.getForObject(pokemonClientConfig.getProtocol() + pokemonClientConfig.getHost() + pokemonClientConfig.getListPokemonCardsPath(), ListPokemonDataResponse.class);
    }
}
