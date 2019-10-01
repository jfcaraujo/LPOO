public class GateAnd extends LogicGate {
    public GateAnd(LogicVariable w1, LogicVariable x1, LogicVariable x2) throws ColisionException, CycleException {
        super(w1, x1, x2);
        w1.setFormula(getSymbol() + "(" + x1.getFormula() + "," + x2.getFormula() + ")");
        update();
    }

    public Object[] getInputs() {
        return new LogicVariable[]{input1, input2};
    }

    public String getSymbol() {
        return "AND";
    }

    public void update() {
        this.internalVariable.value=(this.input1.getValue() && this.input2.getValue());
    }
}
