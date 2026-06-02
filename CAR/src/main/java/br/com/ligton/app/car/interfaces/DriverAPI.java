package br.com.ligton.app.car.interfaces;

import br.com.ligton.app.car.domain.Driver;

import br.com.ligton.app.car.domain.DriverRepository;
import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
