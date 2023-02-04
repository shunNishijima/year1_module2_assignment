package ss.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.hotel.bill.Bill;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";
    
    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;
    

    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    
    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item, 
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getPrice(), 0,
        		"GetPrice should return the price of the safe.");
    }

    @Test
    public void testGetPrice(){
        assertEquals(6.36,safe.getPrice());
    }

    @Test
    public void testToString(){
        assertEquals("6.36",safe.toString());
    }

    @Test
    public void testDeactivateSafe(){
        safe.deactivate();
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        safe.close();
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIncorrectPassword(){
        safe.deactivate();
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isActive()&&safe.isOpen());
    }

    @Test
    public void testCorrectPasswordOpen(){
        safe.deactivate();
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isActive()&&safe.isOpen());
    }

    @Test
    public void testWrongPasswordOpen(){
        safe.deactivate();
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive()&&safe.isOpen());
    }

    @Test
    public void testOpenActivate(){
        safe.activate(CORRECT_PASSWORD);
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isActive()&& safe.isOpen());
    }

    @Test
    public void testOpenActivateClose(){
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertTrue(safe.isActive()&&!safe.isOpen());
    }

    @Test
    public void testClose(){
        safe.close();
        assertFalse(safe.isActive()&& safe.isOpen());
    }
}
