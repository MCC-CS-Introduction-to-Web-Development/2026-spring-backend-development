package edu.mcc.codeschool.class20.clients;

import edu.mcc.codeschool.class20.config.PokemonClientConfig;
import edu.mcc.codeschool.class20.models.external.GetPokemonByIdDataResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Component
public class PokemonCardClientV2 {
    private final WebClient webClient;
    private final PokemonClientConfig pokemonClientConfig;


    public PokemonCardClientV2(Builder webClientBuilder, PokemonClientConfig pokemonClientConfig) {
        this.webClient = webClientBuilder
                .baseUrl(pokemonClientConfig.getProtocol() + pokemonClientConfig.getHost())
                .defaultHeaders(httpHeaders())
                .build();
        this.pokemonClientConfig = pokemonClientConfig;
    }

    private Consumer<HttpHeaders> httpHeaders(){
        return httpHeaders -> {
            httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            // add whatever else you might need here... Hint hint API keys etc......
        };
    }

    public Mono<GetPokemonByIdDataResponse> getPokemonCardById(String id){
        System.out.println(pokemonClientConfig.getGetPokemonCardByIdPath());
        return webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(pokemonClientConfig.getGetPokemonCardByIdPath())
//                                .queryParam("whateverYouCallit", "value")
                                .build(id)
                        ).retrieve()
                        .bodyToMono(GetPokemonByIdDataResponse.class);
    }
}
