package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	//Executa antes de inicilizar o teste
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Luis Felipe", LocalDate.now(), new BigDecimal("1000"));
		System.out.println("Inicializando");
	}
	
	//Executa depois dos testes
	@AfterEach
	public void finalizar() {
		System.out.println("Fim");
	}
	
	//O que rodas todos antes precisa do static
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Ante de todos");
	}
	//O que roda depois de todos precisa de static
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Depois de todos");
	}

	@Test
	void reajusteDeveriaSer3PorcentoQuandoDesempenhoForADesejar() {
		service.ConcederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajustedeveriaSerMaior15QuandoDesempenhoForBom() {
		service.ConcederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());	
	}
	
	@Test
	void reajustedeveriaSerMaior20QuandoDesempenhoForBom() {
		service.ConcederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());	
	}
}
