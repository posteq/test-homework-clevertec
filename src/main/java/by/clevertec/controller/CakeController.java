package by.clevertec.controller;

import by.clevertec.domain.Cake;
import by.clevertec.exeption.CakeNotFoundException;
import by.clevertec.service.CakeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cakes")
public class CakeController {

    private final CakeService cakeService;

    @GetMapping
    public ResponseEntity<List<Cake>> findAll(){
        List<Cake> cakes = cakeService.getCakes();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cakes);
    }

    @GetMapping("/{cakeId}")
    public ResponseEntity<Cake> getCakeById(@PathVariable(name = "cakeId") UUID cakeId) {
        Cake cake = cakeService.getCakeById(cakeId);

        return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(cake);
    }

    @PostMapping
    public ResponseEntity<Cake> createCake(@RequestBody Cake cake) {
        Cake createdCake = cakeService.create(cake);
        return ResponseEntity.created(URI.create("/api/v1/cakes"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdCake);
    }

    @PutMapping("/{cakeId}")
    public ResponseEntity<Cake> updateCake(@PathVariable("cakeId") UUID cakeId, @RequestBody Cake cake) {
        Cake newCake = cakeService.update(cakeId, cake);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(newCake);
    }

    @DeleteMapping("/{cakeId}")
    public ResponseEntity<Void> deleteCake(@PathVariable("cakeId") UUID cakeId) {
        cakeService.delete(cakeId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CakeNotFoundException.class)
    public ResponseEntity<String> handleCakeNotFoundException(CakeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
