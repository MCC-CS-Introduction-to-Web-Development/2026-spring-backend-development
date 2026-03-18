package edu.mcc.codeschool.class19.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.pokemon")
public class PokemonClientConfig {
    private String host;
    private String listPokemonCardsPath;
    private String protocol;

    public String getHost() {
        return host;
    }

    public PokemonClientConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getListPokemonCardsPath() {
        return listPokemonCardsPath;
    }

    public PokemonClientConfig setListPokemonCardsPath(String listPokemonCardsPath) {
        this.listPokemonCardsPath = listPokemonCardsPath;
        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public PokemonClientConfig setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
}
