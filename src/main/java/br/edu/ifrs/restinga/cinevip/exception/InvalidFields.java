package br.edu.ifrs.restinga.cinevip.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidFields {
    
    private String fieldName;
    private String errorMessage;
}
