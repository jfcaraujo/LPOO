import java.util.ArrayList;
import java.util.List;

public class Party extends Event{

    List<Event> events = new ArrayList<>();

    public Party(String name, String date, String description) {
        super(name, date, description);
    }


    public void addEvent(Event e) {
        events.add(e);
        this.attendees.addAll(e.getAttendees());
    }
}
