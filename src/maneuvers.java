import java.util.Random;

public class maneuvers extends Move{

    private final double percentage;

    public maneuvers(double percentage) {
        this.percentage = percentage;
    }

    @Override
    boolean canExecute(General general){
        return general.getMoney()>percentage*general.army.size();
    }
    @Override
    void execute(General general){

        Random generator = new Random();


        for (int i=0; i<general.army.size()*percentage;i++){
            int randomNumber=generator.nextInt(general.army.size());
            general.army.get(randomNumber).experienceGain();
            general.substractMoney(general.army.get(randomNumber).getValue());
        }
    }
}
