package ss.week2;
//make query for reveal current setting.
//make query for reveal next setting.
//make command for changing to next setting the order(off → low → medium → high → off).
//make command for changing setting to given setting.
public class ThreeWayLamp {
    //make enum types here
    enum LampSetting {OFF,LOW,MEDIUM,HIGH}
    //call variables
    /**@
     * private invariant setting != null
     */
    private LampSetting setting = LampSetting.OFF;
    /**
     *
     * @return current setting
     */
    //@ requires setting != null;
    //@ ensures \result !=null;
    public LampSetting getSetting() {
        return setting;
    }
    /**
     *
     * @param setting is new setting
     */
    //@ requires setting != null;
    //@ ensures this.setting !=null;
    public void setSetting(LampSetting setting) {
        this.setting = setting;
    }
    //@ requires setting != null;
    //@ ensures  getSetting().ordinal()%4 == \old(getSetting().ordinal())+1;
    public LampSetting nextSetting() {
        setting = getSetting();
        switch (setting){
            case OFF:
                setSetting(LampSetting.LOW);
                break;
            case LOW:
                setSetting(LampSetting.MEDIUM);
                break;
            case MEDIUM:
                setSetting(LampSetting.HIGH);
                break;
            case HIGH:
                setSetting(LampSetting.OFF);
                break;
            default:
                break;
        }
        return setting;
    }
}
