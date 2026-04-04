package com.example.registre;

public class ElectricalComponent extends Component{
    private final double voltage;

    public ElectricalComponent (String name,double weight, double voltage){
        super(name,weight);
        this.voltage = voltage;
    }

    @Override
    public String describe(){
        return "Composant: " + this.name + " (" + this.weight + "kg), max voltage : " + this.voltage;
    }
}
