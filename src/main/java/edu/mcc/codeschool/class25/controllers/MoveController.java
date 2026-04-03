package edu.mcc.codeschool.class25.controllers;

import edu.mcc.codeschool.class22.models.Game;
import edu.mcc.codeschool.class25.models.Move;
import edu.mcc.codeschool.class25.services.MoveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/moves")
public class MoveController {
    private final MoveService moveService;

    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @PostMapping
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
