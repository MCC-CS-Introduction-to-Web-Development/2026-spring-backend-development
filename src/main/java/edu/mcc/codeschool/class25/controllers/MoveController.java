package edu.mcc.codeschool.class25.controllers;

import edu.mcc.codeschool.class22.models.Game;
import edu.mcc.codeschool.class25.models.Move;
import edu.mcc.codeschool.class25.services.MoveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/moves")
@Tag(name = "Move APIs")
public class MoveController {
    private final MoveService moveService;

    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @PostMapping
    @Operation(
            description = "Make a move",
            summary = "This endpoint makes a move in an active game",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "JSON Body",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Move.class, example = "{\n" +
            "  \"gameId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
            "  \"location\": \"1,1\",\n" +
            "  \"player\": \"X\"\n" +
            "}")
                    )
            ),
            responses = {
                    @ApiResponse(
                            description = "Success Response",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Game.class, example = "{\n" +
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
                                            "}")
                            )
                    ),
                    @ApiResponse(
                            description = "Game not Found Response",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = " ")
                            )
                    ),
                    @ApiResponse(
                            description = "Bad Request Response",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(example = " ")
                            )
                    ),
            }
    )
    public ResponseEntity<Game> makeMove(@RequestBody @Valid Move request){
        try {
            Game response = moveService.makeMove(request);
            return response != null ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            if(e.getMessage().equals("Game has winner")){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
