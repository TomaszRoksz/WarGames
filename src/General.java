import java.util.ArrayList;

public class General{
    ArrayList<Soldier> army= new ArrayList<>();
    public double money;
    public String name;

    General(String name, double money) {
        this.name = name;
        this.money = money;
    }

    String getName(){
        return name;
    }

    void addMoney(double income){
        money+=income;
    }

    void subtractMoney(double outcome){
        money-=outcome;
    }

    public double getMoney(){
        return money;
    }

    public Integer getArmyPower(){
        Integer armyPower= 0;

        for(Soldier soldier:this.army) armyPower += soldier.getPower();
        return armyPower;
    }

    public void soldierBurial(Soldier soldier){
        army.remove(soldier);
    }
}
