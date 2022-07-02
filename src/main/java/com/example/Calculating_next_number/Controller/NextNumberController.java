package com.example.Calculating_next_number.Controller;

import com.example.Calculating_next_number.Request.UserRequestBody;
import com.example.Calculating_next_number.Response.NextNumberResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NextNumberController {


    @GetMapping("/FetchNextNumber")
    public NextNumberResponse FetchNextNumber(@RequestBody UserRequestBody userRequestBody) {

        return null;
    }
}
