package edu.mcc.codeschool.class20.models.external;

import java.util.List;

public class ListPokemonDataResponse {
    private List<PokemonCard> data;

    public List<PokemonCard> getData() {
        return data;
    }

    public ListPokemonDataResponse setData(List<PokemonCard> data) {
        this.data = data;
        return this;
    }
}
