package br.com.ligton.app.car.interfaces;

import br.com.ligton.app.car.domain.Driver;

import br.com.ligton.app.car.domain.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@RestController
@RequestMapping(path="drivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {
    private final DriverRepository driverRepository;


    @GetMapping
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("{id}")
    public Driver findDriver(@PathVariable Long id) {
        return driverRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @PutMapping("{id}")
    public Driver fullUpdateDriver(@PathVariable Long id, @RequestBody Driver driver) { // Outra maneira de escrever o @PathVariable

        Driver foundDriver = findDriver(id);
        foundDriver.setName(driver.getName());
        foundDriver.setBirthDate(driver.getBirthDate());
        return driverRepository.save(foundDriver);
    }

    @PatchMapping("{id}")
    public Driver partialUpdateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDriver(id);

        foundDriver.setBirthDate(Optional.ofNullable(driver.getBirthDate())
                .orElse(foundDriver.getBirthDate()));
        foundDriver.setName(Optional.ofNullable(driver.getName())
                .orElse(foundDriver.getName()));

        return driverRepository.save(foundDriver);
    }

    @DeleteMapping("{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverRepository.deleteById(id);
    }
}
