package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	
	@Test
	void reajusteDeveriaSer3PorcentoQuandoDesempenhoForADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario func = new Funcionario("Luis Felipe", LocalDate.now(), new BigDecimal("1000"));
		
		service.ConcederReajuste(func, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), func.getSalario());
	}
	
	@Test
	void reajustedeveriaSerMaior15QuandoDesempenhoForBom() {
		ReajusteService service = new ReajusteService();
		Funcionario func = new Funcionario("Luis Felipe", LocalDate.now(), new BigDecimal("1000"));
		service.ConcederReajuste(func, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), func.getSalario());	
	}
	
	@Test
	void reajustedeveriaSerMaior20QuandoDesempenhoForBom() {
		ReajusteService service = new ReajusteService();
		Funcionario func = new Funcionario("Luis Felipe", LocalDate.now(), new BigDecimal("1000"));
		service.ConcederReajuste(func, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), func.getSalario());	
	}
}
