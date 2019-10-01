import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    private List<LogicVariable> list = new ArrayList<>();

    public boolean addVariable(LogicVariable a) {
        for (LogicVariable l : list)
            if (a.equals(l)) return false;
        list.add(a);
        return true;
    }

    public Object getVariableByName(String x1) {
        for (LogicVariable l : list)
            if (l.getName() == x1)
                return l;
        return null;
    }
}
