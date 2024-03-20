package br.com.estudo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.exceptions.ResourceNotFoundException;
import br.com.estudo.math.SimpleMath;
import br.com.estudo.util.FormatHelper;

@RestController
public class CalculatorController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double soma(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        if (!FormatHelper.isNumeric(numberOne) || !FormatHelper.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please input a number.");
        }
        return SimpleMath.sum(FormatHelper.covertToDouble(numberOne), FormatHelper.covertToDouble(numberTwo));
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        if (!FormatHelper.isNumeric(numberOne) || !FormatHelper.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please input a number.");
        }
        return SimpleMath.sub(FormatHelper.covertToDouble(numberOne), FormatHelper.covertToDouble(numberTwo));
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        if (!FormatHelper.isNumeric(numberOne) || !FormatHelper.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please input a number.");
        }
        return SimpleMath.mult(FormatHelper.covertToDouble(numberOne), FormatHelper.covertToDouble(numberTwo));
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double divi(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        if (!FormatHelper.isNumeric(numberOne) || !FormatHelper.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please input a number.");
        }
        return SimpleMath.divi(FormatHelper.covertToDouble(numberOne), FormatHelper.covertToDouble(numberTwo));
    }

    @GetMapping("/avarage/{numberOne}/{numberTwo}")
    public Double avarage(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        if (!FormatHelper.isNumeric(numberOne) || !FormatHelper.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please input a number.");
        }
        return SimpleMath.avarage(FormatHelper.covertToDouble(numberOne), FormatHelper.covertToDouble(numberTwo));
    }

    @GetMapping("/sqrt/{numberOne}/{numberTwo}")
    public Double sqrt(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws ResourceNotFoundException {
        if (!FormatHelper.isNumeric(numberOne) || !FormatHelper.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please input a number.");
        }
        return SimpleMath.sqrt(FormatHelper.covertToDouble(numberOne), FormatHelper.covertToDouble(numberTwo));
    }
}