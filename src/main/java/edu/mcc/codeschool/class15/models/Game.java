package edu.mcc.codeschool.class15.models;

import java.util.UUID;

public class Game {
    private UUID id;
    private String status;
    private String winner;
    private Integer playerXWins;
    private Integer playerOWins;
    private Integer ties;
    private String[][] board;

    public Game() {
        this.setId(UUID.randomUUID());
        this.setPlayerOWins(0);
        this.setPlayerXWins(0);
        this.setTies(0);
        this.setStatus("In-Progress");
        String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        this.setBoard(board);
    }

    public UUID getId() {
        return id;
    }

    public Game setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Game setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getWinner() {
        return winner;
    }

    public Game setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    public Integer getPlayerXWins() {
        return playerXWins;
    }

    public Game setPlayerXWins(Integer xWins) {
        this.playerXWins = xWins;
        return this;
    }

    public Integer getPlayerOWins() {
        return playerOWins;
    }

    public Game setPlayerOWins(Integer oWins) {
        this.playerOWins = oWins;
        return this;
    }

    public Integer getTies() {
        return ties;
    }

    public Game setTies(Integer ties) {
        this.ties = ties;
        return this;
    }

    public String[][] getBoard() {
        return board;
    }

    public Game setBoard(String[][] board) {
        this.board = board;
        return this;
    }
}
