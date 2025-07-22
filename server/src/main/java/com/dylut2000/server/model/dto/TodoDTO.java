package com.dylut2000.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private String id, title, createdAt, updatedAt;
    private boolean done;

}
