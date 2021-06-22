package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;



public class CarrinhoTest {
	
	private Carrinho carrinho;
	private final Produto televisao = new Produto("Televisao", 1799.00);
	private final Produto chromecast = new Produto("Chromecast", 999.00);
	private final Produto firestick = new Produto ("Firestick", 799.00);
	
	@BeforeEach
	public void setup() {
	carrinho = new Carrinho();
	
	}
	
	@Test
	public void testAddItensNoCarrinho() {
		assertTrue(carrinho.getQtdeItems()==0);
		carrinho.addItem(new Produto("Televisao", 1799.00));
		carrinho.addItem(new Produto("Chromecast", 999.00));
		assertEquals(2, carrinho.getQtdeItems());
	}
	
	@Test
	public void testValorTotalCarrinho() {
		assertTrue(carrinho.getQtdeItems()==0);
		carrinho.addItem(new Produto("Televisao", 1799.00));
		carrinho.addItem(new Produto("Chromecast", 999.00));
		carrinho.addItem(new Produto("Firestick", 799.00));
		assertEquals(3597, carrinho.getValorTotal());
	}
	
	@Test
	public void testRemoveItemNaoEncontrado() {
		carrinho.addItem(chromecast);
		carrinho.addItem(firestick);
		assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(televisao));
	}
	
	@Test
	public void testRemoveTodosItens() throws ProdutoNaoEncontradoException{
        carrinho.addItem(televisao);
        carrinho.addItem(chromecast);
        carrinho.addItem(firestick);
        assertEquals(3, carrinho.getQtdeItems());
        carrinho.removeItem(televisao);
        carrinho.removeItem(chromecast);
        assertTrue(carrinho.getQtdeItems() == 1);
	}
	
	@Test
	public void testEsvaziarCarrinho() {
		carrinho.addItem(televisao);
		carrinho.addItem(televisao);
		carrinho.addItem(televisao);
        carrinho.addItem(chromecast);
        carrinho.addItem(firestick);
        assertEquals(5, carrinho.getQtdeItems());
        carrinho.esvazia();
        assertTrue(carrinho.getQtdeItems() == 0);
	}
	
	@Test
	public void testValorCarrinhoVazio() throws ProdutoNaoEncontradoException {
		carrinho.addItem(televisao);
        carrinho.addItem(chromecast);
        carrinho.addItem(firestick);
        assertEquals(3597, carrinho.getValorTotal());
        carrinho.removeItem(televisao);
        carrinho.removeItem(chromecast);
        carrinho.removeItem(firestick);
		assertTrue(carrinho.getValorTotal() == 0.0);
	}

}
