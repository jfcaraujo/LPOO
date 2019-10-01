public abstract class LogicGate {
    protected LogicVariable internalVariable, input1, input2;

    public LogicGate(LogicVariable internalVariable, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
        input1.checkDependencies(internalVariable, input2);
        if (input2 != null) input2.checkDependencies(internalVariable, input2);
        if (internalVariable.getCalculatedBy() != null) throw new ColisionException();
        this.internalVariable = internalVariable;
        this.input1 = input1;
        this.input2 = input2;
        this.internalVariable.setCalculatedBy(this);

    }

    public LogicVariable getOutput() {
        return internalVariable;
    }

    public abstract Object[] getInputs();

    public abstract String getSymbol();

    public String getFormula() {
        return internalVariable.getFormula();
    }

    public abstract void update();
}
