package edu.mcc.codeschool.class14.controllers;

import edu.mcc.codeschool.class14.models.Drink;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/drinks")
public class DrinkController {
    Logger logger = Logger.getLogger(DrinkController.class.getName());

    List<Drink> drinks = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok(drinks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable String id){
        Optional<Drink> foundDrink = drinks.stream().filter(drink -> drink.getId().toString().equals(id)).findFirst();
        if(foundDrink.isPresent()){
            return ResponseEntity.ok(foundDrink.get());
        } else {
            logger.info("Drink with ID of " + id + " was not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Drink> createDrink(@Valid @RequestBody Drink request){
        request.setId(UUID.randomUUID());
        drinks.add(request);
        return ResponseEntity.ok(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@Valid @RequestBody Drink request, @PathVariable String id) {
        Optional<Drink> foundDrink = drinks.stream().filter(drink -> drink.getId().toString().equals(id)).findFirst();
        if(foundDrink.isPresent()){
            drinks.remove(foundDrink.get());
            request.setId(UUID.fromString(id));
            drinks.add(request);
            return ResponseEntity.ok(request);
        } else {
            logger.info("Drink with ID of " + id + " was not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
