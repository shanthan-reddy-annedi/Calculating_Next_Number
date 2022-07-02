package com.example.Calculating_next_number.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Calculating_next_number.Model.NextNumberModel;
import com.example.Calculating_next_number.Repo.NextNumberRepo;
import com.example.Calculating_next_number.Request.UserRequestBody;
import com.example.Calculating_next_number.Response.NextNumberResponse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {NextNumberService.class})
@ExtendWith(SpringExtension.class)
class NextNumberServiceTest {
    @MockBean
    private NextNumberRepo nextNumberRepo;

    @Autowired
    private NextNumberService nextNumberService;

    @Test
    void testOperations() {
        NextNumberModel nextNumberModel = new NextNumberModel();
        nextNumberModel.setCategoryCode(1);
        nextNumberModel.setValue(42);

        NextNumberModel nextNumberModel1 = new NextNumberModel();
        nextNumberModel1.setCategoryCode(1);
        nextNumberModel1.setValue(42);
        Optional<NextNumberModel> ofResult = Optional.of(nextNumberModel1);
        when(nextNumberRepo.save((NextNumberModel) any())).thenReturn(nextNumberModel);
        when(nextNumberRepo.findById((Integer) any())).thenReturn(ofResult);
        NextNumberResponse actualOperationsResult = nextNumberService.operations(new UserRequestBody(1));
        assertEquals(1, actualOperationsResult.getCategoryCode());
        assertEquals(42, actualOperationsResult.getOldValue());
        assertEquals(46, actualOperationsResult.getNewValue());
        verify(nextNumberRepo).save((NextNumberModel) any());
        verify(nextNumberRepo).findById((Integer) any());
    }


    @Test
    void testOperations2() {
        NextNumberModel nextNumberModel = new NextNumberModel();
        nextNumberModel.setCategoryCode(1);
        nextNumberModel.setValue(42);
        NextNumberModel nextNumberModel1 = mock(NextNumberModel.class);
        when(nextNumberModel1.getCategoryCode()).thenReturn(1);
        when(nextNumberModel1.getValue()).thenReturn(42);
        doNothing().when(nextNumberModel1).setCategoryCode(anyInt());
        doNothing().when(nextNumberModel1).setValue(anyInt());
        nextNumberModel1.setCategoryCode(1);
        nextNumberModel1.setValue(42);
        Optional<NextNumberModel> ofResult = Optional.of(nextNumberModel1);
        when(nextNumberRepo.save((NextNumberModel) any())).thenReturn(nextNumberModel);
        when(nextNumberRepo.findById((Integer) any())).thenReturn(ofResult);
        NextNumberResponse actualOperationsResult = nextNumberService.operations(new UserRequestBody(1));
        assertEquals(1, actualOperationsResult.getCategoryCode());
        assertEquals(42, actualOperationsResult.getOldValue());
        assertEquals(46, actualOperationsResult.getNewValue());
        verify(nextNumberRepo).save((NextNumberModel) any());
        verify(nextNumberRepo).findById((Integer) any());
        verify(nextNumberModel1).getCategoryCode();
        verify(nextNumberModel1).getValue();
        verify(nextNumberModel1).setCategoryCode(anyInt());
        verify(nextNumberModel1, atLeast(1)).setValue(anyInt());
    }

}

