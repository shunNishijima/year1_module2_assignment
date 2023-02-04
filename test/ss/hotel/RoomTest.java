package test.ss.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.hotel.Guest;
import ss.hotel.Room;
import ss.hotel.Safe;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe safe;
    
    @BeforeEach
    public void setUp() {
        guest = new Guest("Jip");
        safe = new Safe();
        room = new Room(101,safe);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    @Test
    public void testSafe(){
        assertEquals(safe,room.getSafe());
    }
}
