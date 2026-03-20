package edu.mcc.codeschool.class20.models.external;

public class GetPokemonByIdDataResponse {
    private PokemonCard data;

    public PokemonCard getData() {
        return data;
    }

    public GetPokemonByIdDataResponse setData(PokemonCard data) {
        this.data = data;
        return this;
    }
}
