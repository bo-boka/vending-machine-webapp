/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.controller;

import com.tsguild.vendingmachinewebapp.validation.ValidationErrorContainer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */

@ControllerAdvice
public class RestValidationHandler {
    
    
    //Effectively kinda like a "Catch" for Controller excepts
    
    @ExceptionHandler(MethodArgumentNotValidException.class) //what makes it catch
    @ResponseBody @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorContainer processValidationErrors(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        ValidationErrorContainer errors = new ValidationErrorContainer();
        for(FieldError fError : fieldErrors) {
            errors.addValidationError(fError.getField(), fError.getDefaultMessage());
        }
        return errors;
    }
}
