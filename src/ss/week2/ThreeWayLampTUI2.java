package ss.week2;

import java.util.Scanner;

public class ThreeWayLampTUI2 {
    ThreeWayLamp setting;
    public  ThreeWayLampTUI2(){
        this.setting = new ThreeWayLamp();
    }
    public static void main(String[] args) {
        ThreeWayLampTUI2 s = new ThreeWayLampTUI2();
        run(s);
    }
    public static void run(ThreeWayLampTUI2 s) {
        int i = 0;
        while (i <= 0) {
            System.out.println("help menu: " +
                    "OFF, LOW, MEDIUM, HIGH, STATE, NEXT, HELP, EXIT");
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();
            switch (option) {
                case "OFF":
                    s.setting.setSetting(ThreeWayLamp.LampSetting.OFF);
                    break;
                case "LOW":
                    s.setting.setSetting(ThreeWayLamp.LampSetting.LOW);
                    break;
                case "MEDIUM":
                    s.setting.setSetting(ThreeWayLamp.LampSetting.MEDIUM);
                    break;
                case "HIGH":
                    s.setting.setSetting(ThreeWayLamp.LampSetting.HIGH);
                    break;
                case "STATE":
                    System.out.println(s.setting.getSetting());
                    break;
                case "NEXT":
                    s.setting.nextSetting();
                    break;
                case "HELP":
                    System.out.println("• OFF: Set the lamp to OFF" + "\n" +
                            "• LOW: Set the lamp to LOW" + "\n" +
                            "• MEDIUM: Set the lamp to MEDIUM" + "\n" +
                            "• HIGH: Set the lamp to HIGH" + "\n" +
                            "• STATE: Print the current setting of the lamp" + "\n" +
                            "• NEXT: Change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH → OFF" + "\n" +
                            "• HELP: Show a help menu, explaining how the user should interact with the program" + "\n" +
                            "• EXIT: Quit the program ");
                    break;
                case "EXIT":
                    i++;
                    break;
                default:
                    i++;
                    break;
            }
        }
    }}