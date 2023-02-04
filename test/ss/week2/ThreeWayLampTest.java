package ss.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeWayLampTest {
    //Test variable
    private ThreeWayLamp setting;

    @BeforeEach
    public  void setup(){
        setting = new ThreeWayLamp();
        setting.setSetting(ThreeWayLamp.LampSetting.OFF);
    }

    @Test
    public void testitself(){
        assertEquals(ThreeWayLamp.LampSetting.OFF,setting.getSetting());
    }
    @Test
    public void sequence(){
        setting.nextSetting();
        assertEquals(ThreeWayLamp.LampSetting.LOW,setting.getSetting());
        setting.nextSetting();
        assertEquals(ThreeWayLamp.LampSetting.MEDIUM,setting.getSetting());
        setting.nextSetting();
        assertEquals(ThreeWayLamp.LampSetting.HIGH,setting.getSetting());
        setting.nextSetting();
        assertEquals(ThreeWayLamp.LampSetting.OFF,setting.getSetting());
    }
    @Test
    public void set(){
        setting.setSetting(ThreeWayLamp.LampSetting.HIGH);
        assertEquals(ThreeWayLamp.LampSetting.HIGH,setting.getSetting());
        setting.setSetting(ThreeWayLamp.LampSetting.OFF);
        assertEquals(ThreeWayLamp.LampSetting.OFF,setting.getSetting());
    }
}
