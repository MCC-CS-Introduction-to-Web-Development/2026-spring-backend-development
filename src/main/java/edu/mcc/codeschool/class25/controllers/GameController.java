package edu.mcc.codeschool.class25.controllers;

import edu.mcc.codeschool.class22.models.Game;
import edu.mcc.codeschool.class25.models.Move;
import edu.mcc.codeschool.class25.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/games")
@Tag(name = "Game APIs")
public class GameController {
    private final GameService gameService;

    private final String EXAMPLE_GAME_BOARD =  "{\n" +
            "  \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
            "  \"status\": \"In-Progress\",\n" +
            "  \"winner\": null,\n" +
            "  \"playerXWins\": 0,\n" +
            "  \"playerOWins\": 0,\n" +
            "  \"ties\": 0,\n" +
            "  \"board\": [\n" +
            "    [\n" +
            "      [\"\", \"\", \"\"],\n" +
            "      [\"\", \"X\", \"\"],\n" +
            "      [\"\", \"\", \"\"]\n" +
            "    ]\n" +
            "  ]\n" +
            "}";

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @Operation(
            description = "Get all games",
            summary = "API to list all active games",
            responses = {
                    @ApiResponse(
                            description = "Success Response",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Game.class, example ="[\n" + EXAMPLE_GAME_BOARD + "\n]")
                            )
                    )
            }
    )
    public ResponseEntity<Game> createGame(){
        Game result = gameService.createGame();
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Game>> listGames(){
        return ResponseEntity.ok(gameService.listGames());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from spring boot game controller");
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Get Game by ID",
            summary = "This endpoint returns a game, if found, by it's ID",
            parameters = @Parameter(
              name = "id",
              description = "The id of the game you want to find",
              example =  "3fa85f64-5717-4562-b3fc-2c963f66afa6"
            ),
            responses = {
                    @ApiResponse(
                            description = "Success Response",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Game.class, example = EXAMPLE_GAME_BOARD)
                            )
                    ),
                    @ApiResponse(
                            description = "Game not Found Response",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = " ")
                            )
                    )
            }
    )
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
