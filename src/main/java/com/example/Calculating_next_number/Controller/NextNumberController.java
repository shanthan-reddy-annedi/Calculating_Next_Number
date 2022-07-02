package com.example.Calculating_next_number.Controller;

import com.example.Calculating_next_number.Request.UserRequestBody;
import com.example.Calculating_next_number.Response.NextNumberResponse;
import com.example.Calculating_next_number.Service.NextNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class NextNumberController {

    @Autowired
    NextNumberService nextNumberService;

    @PostMapping("/FetchNextNumber")
    public NextNumberResponse FetchNextNumber(@RequestBody UserRequestBody userRequestBody) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
       return nextNumberService.operations(userRequestBody);

    }
}
