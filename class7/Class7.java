package class7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Class7 {

    static void main(){
        List<Pokemon> mySickPokemon = new ArrayList<>(Arrays.asList(
                new Pokemon("Squirtle", "water"),
                new Pokemon("Charmander", "fire", "Iain", 69, 100.0),
                new Pokemon("Eevee", "normal"),
                new Pokemon("Pikachu", "electric", "Chris", 45, 120.21),
                new Pokemon("Gengar", "ghost"),
                new Pokemon("Pichu", "electric"),
                new Pokemon("Blastoise", "water")
        ));


        List<MyPokemon> myPokemons = mySickPokemon.stream()
                        .map(pokemon -> new MyPokemon(pokemon.getName(), pokemon.getType()))
                        .toList();
        myPokemons.forEach(System.out::println);

        System.out.println("===========================");

        mySickPokemon.sort(Comparator.comparing(Pokemon::getType).reversed().thenComparing(Pokemon::getName));
        mySickPokemon.forEach(pokemon -> System.out.println(pokemon.getName()));


        System.out.println("===========================");

        mySickPokemon.stream()
                .filter(pokemon -> pokemon.getLevel() > 5)
                .toList()
                .forEach(pokemon -> System.out.println(pokemon.getName()));

        System.out.println("===========================");


        mySickPokemon.stream()
                .filter(pokemon -> pokemon.getType().equalsIgnoreCase("electric") || pokemon.getType().equalsIgnoreCase("water"))
                .toList()
                .forEach(pokemon -> System.out.println(pokemon.getName()));


        System.out.println("===========================");

        List<String> pokemonNames = mySickPokemon.stream()
                .filter(pokemon -> pokemon.getType().equalsIgnoreCase("electric") || pokemon.getType().equalsIgnoreCase("water"))
                .map(Pokemon::getName)
                .toList();

        pokemonNames.forEach(System.out::println);

    }


    static class Pokemon{
        private String name;
        private String type;
        private String trainer;
        private Integer level;
        private Double hp;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
            this.level = 1;
        }

        public Pokemon(String name, String type, String trainer, Integer level, Double hp) {
            this.name = name;
            this.type = type;
            this.trainer = trainer;
            this.level = level;
            this.hp = hp;
        }

        public Pokemon() {
            this.level = 1;
            this.type = "normal";
        }

        public String getName() {
            return name;
        }

        public Pokemon setName(String name) {
            this.name = name;
            return this;
        }

        public String getType() {
            return type;
        }

        public Pokemon setType(String type) {
            this.type = type;
            return this;
        }

        public String getTrainer() {
            return trainer;
        }

        public Pokemon setTrainer(String trainer) {
            this.trainer = trainer;
            return this;
        }

        public Integer getLevel() {
            return level;
        }

        public Pokemon setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Double getHp() {
            return hp;
        }

        public Pokemon setHp(Double hp) {
            this.hp = hp;
            return this;
        }
    }

    static class MyPokemon{
        private String name;
        private String type;
        private String thing;

        public MyPokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return "MyPokemon{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", thing='" + thing + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public MyPokemon setName(String name) {
            this.name = name;
            return this;
        }

        public String getType() {
            return type;
        }

        public MyPokemon setType(String type) {
            this.type = type;
            return this;
        }

        public String getThing() {
            return thing;
        }

        public MyPokemon setThing(String thing) {
            this.thing = thing;
            return this;
        }
    }

}
