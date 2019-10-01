import java.util.ArrayList;
import java.util.List;

public abstract class Facility {
    protected List<User> users= new ArrayList<>();
    public abstract String getName();

    @Override
    public abstract String toString();

    public boolean canEnter(User u1) {
        for (User user:users)
            if (user==u1)
                return true;
            return false;
    }
}
