package edu.mcc.codeschool.class22.controllers;

import edu.mcc.codeschool.class22.models.Game;
import edu.mcc.codeschool.class22.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> createGame(){
        Game result = gameService.createGame();
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Game>> listGames(){
        return ResponseEntity.ok(gameService.listGames());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> listGames(){
        return ResponseEntity.ok("Hello from spring boot game controller");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable String id){
        Optional<Game> game =  gameService.getGameById(id);
        return game.isPresent() ? ResponseEntity.ok(game.get()) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/clear/{id}")
    public ResponseEntity<Game> clearGame(@PathVariable String id){
        Game resp = gameService.clearGame(id);
        return resp != null ? ResponseEntity.ok(resp) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reset/{id}")
    public ResponseEntity<Game> resetGame(@PathVariable String id){
        Game resp = gameService.resetGame(id);
        return resp != null ? ResponseEntity.ok(resp) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable String id){
        return gameService.deleteGame(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
