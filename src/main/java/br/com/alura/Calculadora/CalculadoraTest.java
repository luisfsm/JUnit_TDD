package br.com.alura.Calculadora;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {

	@Test
    public void deveriaSomarDoisNumerosInteiros(){
        Calculadora calc =  new Calculadora();
        int soma =  calc.somar(7, 3);
        //Assert Class Junit pra validar dados, JUnit.assertEquals verifica se os dados são iguais 
        Assert.assertEquals(10, soma);
    }
    
}
