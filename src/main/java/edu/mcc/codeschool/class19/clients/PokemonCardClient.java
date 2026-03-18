package edu.mcc.codeschool.class19.clients;

import edu.mcc.codeschool.class19.config.PokemonClientConfig;
import edu.mcc.codeschool.class19.models.external.PokemonDataResponse;
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

    public PokemonDataResponse listPokemonCards(){
        return restTemplate.getForObject(pokemonClientConfig.getProtocol() + pokemonClientConfig.getHost() + pokemonClientConfig.getListPokemonCardsPath(), PokemonDataResponse.class);
    }
}
