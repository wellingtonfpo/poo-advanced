package br.com.ligton.app.car.interfaces;

import br.com.ligton.app.car.domain.Driver;

import br.com.ligton.app.car.domain.DriverRepository;
import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Uso do Lombok para gerar o construtor com os campos finais
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    // Abordagem 1: Injeção de dependência diretamente no atributo (Não recomendada)
    // @Autowired
    // DriverRepository driverRepository;

    // Abordagem 2: Injeção de dependência via construtor (Recomendada)
    private final DriverRepository driverRepository;

    // public DriverAPI(DriverRepository driverRepository) {
    //    this.driverRepository = driverRepository;
    //}


    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver findDriver(@PathVariable("id") Long id) {

        // Abordagem sem tratamento de exceção, retorna 500 se o ID não for encontrado
        // return driverRepository.findById(id).get();

        return driverRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @PutMapping("/drivers/{id}")
    public Driver fullUpdateDriver(@PathVariable Long id, @RequestBody Driver driver) { // Outra maneira de escrever o @PathVariable

        Driver foundDriver = findDriver(id);
        foundDriver.setName(driver.getName());
        foundDriver.setBirthDate(driver.getBirthDate());
        return driverRepository.save(foundDriver);
    }

    @PatchMapping("/drivers/{id}")
    public Driver partialUpdateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDriver(id);

        foundDriver.setBirthDate(Optional.ofNullable(driver.getBirthDate())
                .orElse(foundDriver.getBirthDate()));
        foundDriver.setName(Optional.ofNullable(driver.getName())
                .orElse(foundDriver.getName()));

        return driverRepository.save(foundDriver);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverRepository.deleteById(id);
    }
}
