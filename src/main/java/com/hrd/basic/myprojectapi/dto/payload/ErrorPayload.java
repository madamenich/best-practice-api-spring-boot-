package com.hrd.basic.myprojectapi.dto.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorPayload {
    private String field;
    private String message;
}
