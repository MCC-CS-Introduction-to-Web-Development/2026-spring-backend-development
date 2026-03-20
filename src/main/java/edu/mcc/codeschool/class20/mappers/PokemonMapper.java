package edu.mcc.codeschool.class20.mappers;

import edu.mcc.codeschool.class20.models.Pokemon;
import edu.mcc.codeschool.class20.models.external.PokemonCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "cardName", source = "name")
    @Mapping(target = "hp", ignore = true)
    @Mapping(target = "averagePrice", source = "cardmarket.prices.averageSellPrice")
    @Mapping(target = "bestInstructor", constant = "Evan Stohlmann")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Pokemon mapPokemon(PokemonCard card);
}
