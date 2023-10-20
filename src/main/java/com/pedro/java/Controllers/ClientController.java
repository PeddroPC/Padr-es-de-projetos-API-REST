package com.pedro.java.Controllers;

import com.pedro.java.Model.Client;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @PostMapping("/cliente")
    public void client(@Valid @RequestBody Client obj){

    }

}
