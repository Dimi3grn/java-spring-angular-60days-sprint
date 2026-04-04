package com.example.registre;

public class MechanicalComponent extends Component{
    private final double maxRPM;
    
    public MechanicalComponent(String name, double weight,double maxRPM){
        super(name,weight);
        this.maxRPM = maxRPM;
    }

    @Override
    public String describe(){
        return "Composant: " + this.name + " (" + this.weight + "kg), max RPM : " + this.maxRPM;
    }
}
