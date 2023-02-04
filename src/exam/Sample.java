package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sample {
}

/** Location of a show. */
class Location {
    /** Address of the location. */
    public final String name;
    /** Number of seats of the location. */
    public final int capacity;
    /** Constructs a new location. */
    public Location(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
interface Show{
    //A method getPrice that returns the price of a ticket (a double);
    /*@
        ensures \result!=0;
        pure;
    */
    double getPrice();
    //A method getDiscount that returns a price discount percentage for frequent customers (an int between 0 and 100);
    /*@
        ensures \result>=0&&\result<=100;
        pure;
    */
    int getDiscount();
    //A method setDiscount that sets the discount percentage to a new value;
    /*@
        ensures getDiscount()==Discount;
    */
    void setDiscount(int Discount);
    //A method getDiscountPrice that returns the discounted price;
    /*@
        ensures \result==getPrice()*getDiscount()/100;
    */
    double getDiscountPrice();
    //A method getLocation that returns the Location where the show takes place;
    /*@
        ensures \result!=null;
    */
    Location getLocation();
    //A method getCapacity that returns the location capacity, i.e., it’s number of seats (an int).
    /*@
        ensures \result>0;
    */
    int getCapacity();
}
enum Genre{comedy, musical, western,romance}
interface TypedShow extends Show{
    //addGenre which adds a Genre (provided as parameter) to the set;
    /*@
        requires genre!=null;
        ensures getGenres().contains(genre);
    */
    void addGenre(Genre genre);
    //getGenres which returns the set of all genres of the TypedShow.
    /*@
        ensures !\result.isEmpty();
        pure;
    */
    Set<Genre> getGenres();
}
class Movie implements TypedShow{
    private Location location;
    private double price;
    private int Discount;
    private Set<Genre> genres = new HashSet<>();

    public Movie(Location location,double price){
        this.location = location;
        this.price = price;
    }
    /**
     * @return
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * @return
     */
    @Override
    public int getDiscount() {
        return this.Discount;
    }

    /**
     *
     */
    @Override
    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    /**
     * @return
     */
    @Override
    public double getDiscountPrice() {
        return this.price*this.Discount/100;
    }

    /**
     * @return
     */
    @Override
    public Location getLocation() {
        return this.location;
    }

    /**
     * @return
     */
    @Override
    public int getCapacity() {
        return this.location.capacity;
    }

    /**
     *
     */
    @Override
    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    /**
     * @return
     */
    @Override
    public Set<Genre> getGenres() {
        return this.genres;
    }
}
class Profile {
    /** Number of booked shows required to be frequent customer. */
    public static final int FREQUENT_CUSTOMER = 10;
    /** Name of this profile. */
    public final String name;
    /** Chosen shows. */
    private final Set<Show> choices = new HashSet<>();
    /** Preferential genres, i.e., which occur in at least one chosen show. */
    private final Set<Genre> prefs = new HashSet<>();
    /** Constructs a profile for a given name. */
    public Profile(String name) {
        this.name = name;
    }
    /** Adds a show to the choices and preferences of this profile.
     * @return true if the show is new for this profile, false otherwise */
    public boolean addChoice(Show show) {
        //The preferences are those genres of which the profile has ever booked a TypedShow;
        if(choices.contains(show)){
            return false;
        }else {
            choices.add(show);
            return true;
        }
    }
    /** Returns the set of chosen shows. */
    public Set<Show> getChoices() {
        return choices;
    }
    /** Returns the collected preferences in the chosen shows. */
    public Set<Genre> getPrefs() {
        return prefs;
    }
    /** Tests if this profile represents a frequent customer. */
    public boolean isFrequent() {
        //A profile represents a frequent customer if the number of chosen shows is as least as large as
        return choices.size()>=FREQUENT_CUSTOMER;
    }
}

class Agency {
    /** Map from shows to number of tickets sold for that show. */
    private final Map<Show, Integer> soldMap = new HashMap<>();
    /** Adds a show to the ones available through this agency. */
    public void addShow(Show show) {
        soldMap.put(show,0);
    }
    /** Returns all shows available through this agency. */
    public Set<Show> getShows() {
        return soldMap.keySet();
    }
    /** Books a number of tickets for a given show. */
    /*@
        requires show.getCapacity()>=soldMap.get(show)+tickets;
        ensures soldMap.get(show)<=show.getCapacity();
    */
    public void bookShow(Show show, int tickets) {
        soldMap.put(show, soldMap.get(show) + tickets);
    }
    /** Returns the number of tickets left for a given show. */
    /*@
        ensures \result>=0;
    */
    public int getSpace(Show show) {
        return show.getCapacity()-soldMap.get(show);
    }
}
abstract class Suggestion {
    /** The agency to which this suggestion belongs. */
    protected final Agency agency;
    /** Constructs a suggestion for a given agency. */
    protected Suggestion(Agency agency) {
        this.agency = agency;
    }
    /** Returns a suggestion for a given customer. */
    abstract public Set<Show> getShows(Profile cust);
}
class GenreOverlap extends Suggestion{

    /**
     * Constructs a suggestion for a given agency.
     *
     * @param agency
     */
    protected GenreOverlap(Agency agency) {
        super(agency);
    }

    /**
     * Returns a suggestion for a given customer.
     *
     * @param cust
     */
    @Override
    public Set<Show> getShows(Profile cust) {
        /** The customer hasn’t yet booked the show;
            The show has at least one of the genres of the customer’s preference;
            The show is not fully booked.
        */
        Set<Show> recommend = new HashSet<>();
        Set<Show> shows = agency.getShows();
        for (Show show: shows){
            if (!cust.getChoices().contains(show)){
                for (Genre genre: ((TypedShow)show).getGenres()){
                    if (cust.getPrefs().contains(genre)){
                        if (agency.getSpace(show)>0){
                            recommend.add(show);
                            break;
                        }
                    }
                }
            }
        }
        return recommend;
    }
}
class GenreInclusion extends Suggestion{

    /**
     * Constructs a suggestion for a given agency.
     *
     * @param agency
     */
    protected GenreInclusion(Agency agency) {
        super(agency);
    }

    /**
     * Returns a suggestion for a given customer.
     *
     * @param cust
     */
    @Override
    public Set<Show> getShows(Profile cust) {
        /**The customer hasn’t yet booked the show;
            The show’s genres completely fall within customer’s preference;
            The show is not fully booked.
         */
        Set<Show> recommend = new HashSet<>();
        Set<Show> shows = agency.getShows();
        for (Show show: shows){
            if (!cust.getChoices().contains(show)){
                if (cust.getPrefs().containsAll(((TypedShow)show).getGenres())){
                    if (agency.getSpace(show)>0){
                        recommend.add(show);
                    }
                }
            }
        }
        return recommend;
    }
}
class TicketException extends Exception{
    TicketException(String s){
        super(s);
    }
}

class Ticket {
    private String owner;
    private Show show;
    private double price;
    public Ticket(Agency agency,Show show,Profile profile) throws TicketException {
        if (agency.getSpace(show)==0){
            throw new TicketException("This Show is fully booked");
        }
        if (profile.getChoices().contains(show)){
            throw new TicketException("This person already booked the show");
        }
        this.show = show;
        this.owner = profile.name;
        if (profile.isFrequent()){
            show.setDiscount(10);
        }
        this.price = show.getDiscountPrice();
    }
    public String getOwner() {
        return owner;
    }
    public Show getShow() {
        return show;
    }
    public double getPrice() {
        return price;
    }
}

class Booking extends Thread {
    private static final Agency TICKET_MASTER = new Agency();
    private static final Location KINEPOLIS = new Location("Kinepolis 1", 150);
    private static final Show ASSASSINS_CREED = new Movie(KINEPOLIS, 12.0);
    public static void main(String[] args) {
        TICKET_MASTER.addShow(ASSASSINS_CREED);
        Booking agnes = new Booking(2);
        Booking bert = new Booking(5);
// start two bookings concurrently
        agnes.start();
        bert.start();
        /**try {
            agnes.join();
            bert.join();
        } catch (InterruptedException exc) {
// do nothing
        }*/
        System.out.println("Tickets left: "
                + TICKET_MASTER.getSpace(ASSASSINS_CREED));
    }
    /** Number of tickets to be booked. */
    private final int count;
    /** Constructs a booking for a given number of tickets. */
    public Booking(int count) {
        this.count = count;
    }
    /** Runs the booking. */
    public void run() {
        synchronized (TICKET_MASTER){
        TICKET_MASTER.bookShow(ASSASSINS_CREED, count);
        }
    }
}

