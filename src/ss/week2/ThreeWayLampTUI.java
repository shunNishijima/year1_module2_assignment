package ss.week2;

import java.util.Scanner;

//there are 3 options choose current setting, print current setting, change to next setting
public interface ThreeWayLampTUI {
    ThreeWayLamp newsetting = new ThreeWayLamp();

    public static void main(String[] args) {
        int i = 0;
        while (i <= 0) {
            System.out.println("Choose options: " +
                    "OFF, LOW, MEDIUM, HIGH, STATE, NEXT, HELP, EXIT");
            Scanner s = new Scanner(System.in);
            String option = s.nextLine();
            switch (option) {
                case "OFF":
                    newsetting.setSetting(ThreeWayLamp.LampSetting.OFF);
                    break;
                case "LOW":
                    newsetting.setSetting(ThreeWayLamp.LampSetting.LOW);
                    break;
                case "MEDIUM":
                    newsetting.setSetting(ThreeWayLamp.LampSetting.MEDIUM);
                    break;
                case "HIGH":
                    newsetting.setSetting(ThreeWayLamp.LampSetting.HIGH);
                    break;
                case "STATE":
                    System.out.println(newsetting.getSetting());
                    break;
                case "NEXT":
                    newsetting.nextSetting();
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
    }
}

