package by.clevertec.controller;

import by.clevertec.domain.Cake;
import by.clevertec.service.CakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CakeController {

    private final CakeService cakeService;

    @GetMapping("/api/v1/cakes")
    public ResponseEntity<List<Cake>> findAll(){
        List<Cake> cakes = cakeService.getCakes();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cakes);
    }
}
