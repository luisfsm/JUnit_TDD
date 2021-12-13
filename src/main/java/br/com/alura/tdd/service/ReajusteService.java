package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void ConcederReajuste(Funcionario func, Desempenho desempenho) {
		
		switch(desempenho) {
			case A_DESEJAR :
				
				BigDecimal reajuste = func.getSalario().multiply(new BigDecimal("0.03"));
				func.reajustarSalario(reajuste);
				
				break;
				
			case BOM :
				
				BigDecimal reajuste1 = func.getSalario().multiply(new BigDecimal("0.15"));
				func.reajustarSalario(reajuste1);
				
				break;
				
			case OTIMO :
				
				BigDecimal reajuste2 = func.getSalario().multiply(new BigDecimal("0.20"));
				func.reajustarSalario(reajuste2);
				
				break;
		}
				
	}

}
