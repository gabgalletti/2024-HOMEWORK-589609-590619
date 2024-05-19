package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.Iterator;

public class BorsaTest {
	Attrezzo attrezzo;
	Borsa borsa;
	@Test
	public void addAttrezzo_null() {
		assertNull(borsa.addAttrezzo(null));
	}
	@Test
	public void test_addAttrezzo_peso_true() {
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
	@Test
	public void test_addAttrezzo_peso_false() {
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	@Test
	public void getAttrezzo_null() {
		assertNull(borsa.getAttrezzo(null));
	}
	@Test
	public void getAttrezzo_Presente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertNotNull(borsa.getAttrezzo("attrezzo"));
	}
	@Test
	public void getAttrezzo_Assente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertNull(borsa.getAttrezzo("attrezzo assente"));
	}
	@Test
	public void test_hasAttrezzo() {
		assertNull(borsa.hasAttrezzo(null));
	}
	@Test
	public void hasAttrezzo_Presente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertTrue(borsa.hasAttrezzo("attrezzo"));
	}
	@Test
	public void hasAttrezzo_Assente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}
	@Test
	public void testSortedPeso() {
		List<Attrezzo> sorted = new ArrayList<Attrezzo>();
		Attrezzo[] attrezzo = new Attrezzo[3];
		sorted.add(attrezzo[0]);
		sorted.add(attrezzo[1]);
		sorted.add(attrezzo[2]);
		borsa.addAttrezzo(attrezzo[0]);
		borsa.addAttrezzo(attrezzo[1]);
		borsa.addAttrezzo(attrezzo[2]);
		assertEquals(sorted, borsa.getContenutoOrdinatoPerPeso());
	}
	@Test
    public void testGetContenutoOrdinatoPerPeso() {
        List<Attrezzo> risultato = borsa.getContenutoOrdinatoPerPeso();
        Attrezzo[] attrezzo = new Attrezzo[3];
        assertEquals(3, risultato.size());
        assertEquals(attrezzo[0], risultato.get(0));
        assertEquals(attrezzo[1], risultato.get(1));
        assertEquals(attrezzo[2], risultato.get(2));
    }

    @Test
    public void testGetContenutoOrdinatoPerNome() {
        SortedSet<Attrezzo> risultato = borsa.getContenutoOrdinatoPerNome();
        Attrezzo[] attrezzo = new Attrezzo[3];
        assertEquals(3, risultato.size());
        Iterator<Attrezzo> iterator = risultato.iterator();
        assertEquals(attrezzo[0], iterator.next());
        assertEquals(attrezzo[1], iterator.next());
        assertEquals(attrezzo[2], iterator.next());
    }

    @Test
    public void testGetContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> risultato = borsa.getContenutoRaggruppatoPerPeso();

        assertEquals(3, risultato.size());
        assertEquals(1, risultato.get(1).size());
        assertEquals(1, risultato.get(2).size());
        assertEquals(1, risultato.get(3).size());
    }

}
