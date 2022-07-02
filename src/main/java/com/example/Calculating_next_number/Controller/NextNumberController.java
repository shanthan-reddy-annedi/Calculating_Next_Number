package com.example.Calculating_next_number.Controller;

import com.example.Calculating_next_number.Request.UserRequestBody;
import com.example.Calculating_next_number.Response.NextNumberResponse;
import com.example.Calculating_next_number.Service.NextNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NextNumberController {

    @Autowired
    NextNumberService nextNumberService;

    @GetMapping("/FetchNextNumber")
    public NextNumberResponse FetchNextNumber(@RequestBody UserRequestBody userRequestBody) throws InterruptedException {
       return nextNumberService.operations(userRequestBody);

    }
}
