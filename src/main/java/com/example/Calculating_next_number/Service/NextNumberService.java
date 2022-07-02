package com.example.Calculating_next_number.Service;

import com.example.Calculating_next_number.Model.NextNumberModel;
import com.example.Calculating_next_number.Repo.NextNumberRepo;
import com.example.Calculating_next_number.Request.UserRequestBody;
import com.example.Calculating_next_number.Response.NextNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.concurrent.TimeUnit;

@Service
public class NextNumberService {

    @Autowired
    NextNumberRepo nextNumberRepo;

    private int digSum(int n) {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }

    private int maxNum(int num) throws InterruptedException {
        while (true){
            ++num;
            if(digSum(num)==1){
                return num;
            }
        }
    }

    private NextNumberModel getEntryFromDb(UserRequestBody userRequestBody){
        int categoryCode =userRequestBody.getCategoryCode();
        NextNumberModel nextNumberModel = nextNumberRepo.findById(categoryCode)
                .orElse(NextNumberModel
                        .builder()
                        .categoryCode(categoryCode)
                        .value(0)
                        .build()
                );
        return nextNumberModel;
    }

    private String update(NextNumberModel nextNumberModel, int updateVlaue){
        nextNumberModel.setValue(updateVlaue);
        try{
            nextNumberRepo.save(nextNumberModel);
            return "updated";
        }catch (Exception e){
            return "error";
        }

    }

    public NextNumberResponse operations(UserRequestBody userRequestBody) throws InterruptedException {
        NextNumberModel nextNumberModel = getEntryFromDb(userRequestBody);
        int oldvalue = nextNumberModel.getValue();
        int updatevalue = maxNum(oldvalue);
        String result = update(nextNumberModel,updatevalue);
        if(result.equals("updated")){
            return NextNumberResponse.builder()
                    .categoryCode(nextNumberModel.getCategoryCode())
                    .oldValue(oldvalue)
                    .newValue(updatevalue)
                    .build();
        }

        return null;
    }

}
