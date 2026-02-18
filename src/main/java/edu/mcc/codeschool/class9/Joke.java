package edu.mcc.codeschool.class9;

public class Joke {
    private Boolean error;
    private String category;
    private String type;
    private String setup;
    private String delivery;
    private String joke;

    public Boolean getError() {
        return error;
    }

    public Joke setError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Joke setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getType() {
        return type;
    }

    public Joke setType(String type) {
        this.type = type;
        return this;
    }

    public String getSetup() {
        return setup;
    }

    public Joke setSetup(String setup) {
        this.setup = setup;
        return this;
    }

    public String getDelivery() {
        return delivery;
    }

    public Joke setDelivery(String delivery) {
        this.delivery = delivery;
        return this;
    }

    public String getJoke() {
        return joke;
    }

    public Joke setJoke(String joke) {
        this.joke = joke;
        return this;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "error=" + error +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", delivery='" + delivery + '\'' +
                ", joke='" + joke + '\'' +
                '}';
    }
}
