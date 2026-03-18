package edu.mcc.codeschool.class19.models.external;

import java.util.List;

public class PokemonCard {
    private String id;
    private String name;
    private String hp;
    private String flavorText;
    private List<String> types;
    private List<Integer> nationalPokedexNumbers;
    private List<Characteristic> weaknesses;
    private List<Characteristic> resistances;
    private List<Abilities> abilities;
    private List<Attacks> attacks;
    private CardMarket cardmarket;
    private String evolvesFrom;

    public String getId() {
        return id;
    }

    public PokemonCard setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PokemonCard setName(String name) {
        this.name = name;
        return this;
    }

    public String getHp() {
        return hp;
    }

    public PokemonCard setHp(String hp) {
        this.hp = hp;
        return this;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public PokemonCard setFlavorText(String flavorText) {
        this.flavorText = flavorText;
        return this;
    }

    public List<String> getTypes() {
        return types;
    }

    public PokemonCard setTypes(List<String> types) {
        this.types = types;
        return this;
    }

    public List<Integer> getNationalPokedexNumbers() {
        return nationalPokedexNumbers;
    }

    public PokemonCard setNationalPokedexNumbers(List<Integer> nationalPokedexNumbers) {
        this.nationalPokedexNumbers = nationalPokedexNumbers;
        return this;
    }

    public List<Characteristic> getWeaknesses() {
        return weaknesses;
    }

    public PokemonCard setWeaknesses(List<Characteristic> weaknesses) {
        this.weaknesses = weaknesses;
        return this;
    }

    public List<Characteristic> getResistances() {
        return resistances;
    }

    public PokemonCard setResistances(List<Characteristic> resistances) {
        this.resistances = resistances;
        return this;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public PokemonCard setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
        return this;
    }

    public List<Attacks> getAttacks() {
        return attacks;
    }

    public PokemonCard setAttacks(List<Attacks> attacks) {
        this.attacks = attacks;
        return this;
    }

    public CardMarket getCardmarket() {
        return cardmarket;
    }

    public PokemonCard setCardmarket(CardMarket cardmarket) {
        this.cardmarket = cardmarket;
        return this;
    }

    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    public PokemonCard setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
        return this;
    }
}
