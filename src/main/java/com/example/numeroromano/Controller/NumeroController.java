package com.example.numeroromano.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NumeroController {
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "hello world com spring";
    }

    @GetMapping("/numero/{param}")
    @ResponseBody
    public String numeroRomano(@PathVariable String param) {
        Integer numero = 0;
        try {
            numero = Integer.parseInt(param);
        } catch (Exception e){
            return "deve receber um número";
        }
        if(numero > 3999){
            return "apenas números até 3999";
        }
        return "O número " + numero + " em romanos é representado assim: " + conversor(numero);
    }

    private String conversor(Integer numero){
        List<String> romanosBaseDez = Arrays.asList("I", "X", "C", "M", "", "");

        List<String> romanosAuxiliares = Arrays.asList("V", "L", "D", "", "");

        String stringNumerica = numero.toString();

        String valorFinal = "";

        for(int i = 0; i < stringNumerica.length(); i++){
            String algarismo =  stringNumerica.substring(i, i+1);

            valorFinal += algarismoRomano(algarismo, romanosBaseDez.get(stringNumerica.length()-i-1), romanosAuxiliares.get(stringNumerica.length()-i-1),romanosBaseDez.get(stringNumerica.length()-i));
        }

        return valorFinal;

    }

    private String algarismoRomano(String numero, String baseDez, String auxiliar, String nextBaseDez){
        String valorFinal = "";

        switch (numero) {
            case "1":
                valorFinal = baseDez;
                break;

            case "2":
                valorFinal = baseDez + baseDez;
                break;

            case "3":
                valorFinal = baseDez + baseDez + baseDez;
                break;

            case "4":
                valorFinal = baseDez + auxiliar;
                break;

            case "5":
                valorFinal = auxiliar;
                break;

            case "6":
                valorFinal = auxiliar + baseDez;
                break;

            case "7":
                valorFinal = auxiliar + baseDez + baseDez;
                break;

            case "8":
                valorFinal = auxiliar + baseDez + baseDez + baseDez;
                break;

            case "9":
                valorFinal = baseDez + nextBaseDez;
                break;
        }
           return valorFinal;
    }
}


