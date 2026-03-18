package edu.mcc.codeschool.class19.models.external;

public class Abilities {
    private String name;
    private String text;
    private String type;

    public String getName() {
        return name;
    }

    public Abilities setName(String name) {
        this.name = name;
        return this;
    }

    public String getText() {
        return text;
    }

    public Abilities setText(String text) {
        this.text = text;
        return this;
    }

    public String getType() {
        return type;
    }

    public Abilities setType(String type) {
        this.type = type;
        return this;
    }
}
