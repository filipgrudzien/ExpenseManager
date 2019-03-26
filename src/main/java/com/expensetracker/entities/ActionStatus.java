package com.expensetracker.entities;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class ActionStatus {

    private String actionStatus;

    public void successfulUserCreation(){
        this.setActionStatus("User has been created successfully!");
    }

    public void resetStatus(){
        this.setActionStatus("");
    }
}
