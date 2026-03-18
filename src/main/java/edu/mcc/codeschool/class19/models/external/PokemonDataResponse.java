package edu.mcc.codeschool.class19.models.external;

import java.util.List;

public class PokemonDataResponse {
    private List<PokemonCard> data;

    public List<PokemonCard> getData() {
        return data;
    }

    public PokemonDataResponse setData(List<PokemonCard> data) {
        this.data = data;
        return this;
    }
}
