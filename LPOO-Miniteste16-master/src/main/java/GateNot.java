public class GateNot extends LogicGate {
    public GateNot(LogicVariable w1, LogicVariable x1) throws ColisionException, CycleException {
        super(w1,x1,null);
        w1.setFormula(getSymbol()+"("+x1.getFormula()+")");
        update();
    }

    public Object[] getInputs() {
        return new LogicVariable[]{input1};
    }

    public String getSymbol() {
        return "NOT";
    }

    public void update() {
        this.internalVariable.value=(!this.input1.getValue());
    }
}
