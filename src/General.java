import java.util.ArrayList;
import java.util.Random;

public class General{
    ArrayList<Soldier> army= new ArrayList<>();
    public double money;

    public General(double money) {
        this.money = money;
    }

    void addMoney(double income){
        money+=income;
    }


    double getMoney(){
        return money;
    }

     void substractMoney(double outcome){
        money-=outcome;
    }

    public Integer getArmyPower(){
        Integer armyPower= 0;

        for(Soldier soldier:this.army) armyPower += soldier.getPower();
        return armyPower;
    }
//
//    @Override
//    public void update(String string) {
//        WriteToFile write= new WriteToFile();
//        write.writeToFile("Current general money: "+money+", current army power: "+
//                getArmyPower()+", current army size: "+army.size()+".");
//
//    }
}
