package ss.hotel;

public class sometest {
    public static void main(String[] args) {
        Hotel h = new Hotel("aaa");

        String name = "Bob";
        Room room = h.getRoom(name);

        System.out.println(room);
        System.out.println(h.getRoom(name));
    }
}
