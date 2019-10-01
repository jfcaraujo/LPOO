public class LogicVariable {
    private String name;
    protected boolean value;
    private LogicGate calculatedBy;
    private String formula;

    public LogicVariable(String name, boolean b) {
        this.name = name;
        value = b;
        calculatedBy = null;
        formula = name;
    }

    public LogicVariable(String s) {
        name = s;
        formula = name;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        if (calculatedBy != null){
            calculatedBy.update();}
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        LogicVariable l = (LogicVariable) o;
        return this.name == l.getName();
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String s) {
        formula = s;
    }

    public void checkDependencies(LogicVariable x1, LogicVariable x2) throws CycleException {
        if (calculatedBy != null) {
            if (x2 != null) {
                if (x2.equals(this.calculatedBy.input1) || x2.equals(this.calculatedBy.input2))
                    throw new CycleException();
            }
            if (x1.equals(this.calculatedBy.input1) || x1.equals(this.calculatedBy.input2))
                throw new CycleException();
        }
    }


}
