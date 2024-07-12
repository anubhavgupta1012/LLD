package com.org.dto;

import com.org.models.User;
import lombok.Data;

@Data
public class Transaction {
    private int amount;
    private User from;
    private User to;

}
