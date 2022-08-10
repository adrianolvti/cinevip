package br.edu.ifrs.restinga.cinevip.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorValidationHandler {

//     public static final String TRACE = "trace";

//     @Value("${reflectoring.trace:false}")
//   private boolean printStackTrace;
    
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<InvalidFields> handler(MethodArgumentNotValidException exception) {

        List<InvalidFields> errors =  new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            InvalidFields error = new  InvalidFields(e.getField(), message);
            errors.add(error);
        });
        return errors;
    }

//     @ExceptionHandler(Exception.class)
//     public StackTraceElement[] handle(Exception ex, 
//                 HttpServletRequest request, HttpServletResponse response) {
  
//         System.out.println("big exceptions");
    
//         return ex.getStackTrace();
    
//   }
  
}
