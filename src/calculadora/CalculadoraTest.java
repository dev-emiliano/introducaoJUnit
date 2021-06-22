package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	//**Meus Testes**
	
	@Test
	public void testMultiplicacaoPorZero() {
		Assertions.assertEquals(0, calc.multiplicacao(9999,0));
	}
	
	@Test
	public void testMultiplicacaoPorUm() {
		assertEquals(9999, calc.multiplicacao(9999,1));
	}
	
	@Test
	public void testMultiplicacaoDeMesmoSinalSempreFicaPositivo() {
		assertEquals(50, calc.multiplicacao(-2,-25));
		assertEquals(50, calc.multiplicacao(2,25));
	}
	
	@Test
	public void testSomaZero() {
		assertEquals(50, calc.soma(0,50));
		assertEquals(50, calc.soma(50,0));
	}
	
	@Test
	public void testSomatoria() {
		assertEquals(55, calc.somatoria(10));
	}
	
	@DisplayName("Testa se o numero � positivo")
	@Test
	public void testVerificaNumeroPositivo() {
		assertTrue(calc.ehPositivo(50));
	}
	
	/*Precisa Falhar s� esse*/
	@DisplayName("Testa se o numero � positivo")
	@Test
	public void testVerificaNumeroNegativo() {
		assertTrue(calc.ehPositivo(-50));
	}
	
}
