package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	@DisplayName("Verifica se salario ultrapassa o bonus de 1000 e o deixa 0")
	void calcularBonusFuncionarioSalarioAlto() {
		BonusService service = new BonusService();
	    assertThrows(IllegalArgumentException.class,
	    			()->service.calcularBonus(new Funcionario("Luis Felipe",LocalDate.now(), new BigDecimal(25000))));
	}
	
	@Test 
	void BonusDeveSerDeDezPorcentos() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Luis Felipe",LocalDate.now(), new BigDecimal(2500)));
		
		assertTrue(bonus.equals(new BigDecimal("250.00")));
		
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDe10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Luis Felipe",LocalDate.now(), new BigDecimal(10000)));
		assertEquals(new BigDecimal("1000.00"), bonus);
		
	}

}
