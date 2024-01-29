import java.util.Random;

public class ManeuversCenter extends Move{

    private final PresidentialSecretary presidentialSecretary;

    public ManeuversCenter(PresidentialSecretary presidentialSecretary) {
        this.presidentialSecretary = presidentialSecretary;
    }

    @Override
    boolean canExecute(General general){
        return general.getMoney()>0.1*general.army.size();
    }

    boolean canExecute(General general, Double percentage){
        return general.getMoney()>percentage*general.army.size();
    }

    @Override
    void execute(General general){

        Random generator = new Random();
        presidentialSecretary.update(general, 0.1);

        for (int i=0; i<general.army.size()*0.1;i++){
            Soldier randomSoldier=general.army.get(generator.nextInt(general.army.size()));
            randomSoldier.experienceGain();
            general.subtractMoney(randomSoldier.getValue());
            presidentialSecretary.update(general, randomSoldier, "gained experience.");
        }
    }

    void execute(General general, Double percentage) {

        Random generator = new Random();
        presidentialSecretary.update(general, percentage);


        for (int i = 0; i < general.army.size() * percentage; i++) {
            Soldier randomSoldier=general.army.get(generator.nextInt(general.army.size()));
            randomSoldier.experienceGain();
            general.subtractMoney(randomSoldier.getValue());
            presidentialSecretary.update(general, randomSoldier, "gained experience.");
        }
    }
}
