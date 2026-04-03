package edu.mcc.codeschool.class25.services;

import edu.mcc.codeschool.class22.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    List<Game> games = new ArrayList<>();

    public Game createGame(){
        Game game = new Game();
        games.add(game);
        return game;
    }

    public List<Game> listGames(){
        return games;
    }

    public Optional<Game> getGameById(String id){
        return games.stream().filter(game -> game.getId().toString().equals(id)).findAny();
    }

    public Game clearGame(String id){
        return clearOrReset(id, false);
    }
    public Game resetGame(String id){
        return clearOrReset(id, true);
    }

    private Game clearOrReset(String id, boolean reset){
        Optional<Game> foundGame = games.stream().filter(game -> game.getId().toString().equals(id)).findAny();
        if(foundGame.isPresent()){
            Game game = foundGame.get();
            games.remove(game);

            String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
            game.setBoard(board);
            game.setStatus("In-Progress");
            game.setWinner(null);
            if(reset){
                game.setTies(0);
                game.setPlayerXWins(0);
                game.setPlayerOWins(0);
            }
            games.add(game);
            return game;
        } else {
            return null;
        }
    }

    public boolean deleteGame(String id){
        Optional<Game> foundGame = games.stream().filter(game -> game.getId().toString().equals(id)).findAny();
        if(foundGame.isPresent()){
            games.remove(foundGame.get());
            return true;
        } else {
            return false;
        }
    }

    public Game updateGame(Game toUpdate){
        Optional<Game> foundGame = games.stream().filter(game -> game.getId().toString().equals(toUpdate.getId().toString())).findAny();
        if(foundGame.isPresent()){
            Game game = foundGame.get();
            games.remove(game);
            games.add(toUpdate);
            return game;
        } else {
            return null;
        }
    }

}
