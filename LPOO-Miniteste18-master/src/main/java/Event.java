import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title, date, description;
    protected List<Person> attendees = new ArrayList<>();

    public Event(String name) {
        this.title = name;
        this.date = "";
        this.description = "";
    }

    public Event(String name, String date) {
        this.title = name;
        this.date = date;
        this.description = "";
    }

    public Event(String name, String date, String description) {
        this.title = name;
        this.date = date;
        this.description = description;
    }

    public Event(Event e) {
        this.title = e.title;
        this.date = e.date;
        this.description = e.description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass())
            return false;
        Event e = (Event) o;
        return this.title == e.title && this.date == e.date && this.description == e.description;
    }

    public void addPerson(Person person) {
        //(!this.attendees.contains(attendee))
        for (Person p : this.attendees)
            if (p.getName() == person.getName())
                return;
        attendees.add(person);
    }

    public int getAudienceCount() {
        return attendees.size();
    }

    public List<Person> getAttendees(){
        return attendees;
    }
}
