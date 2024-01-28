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


        for (int i=0; i<general.army.size()*0.1;i++){
            int randomNumber=generator.nextInt(general.army.size());
            general.army.get(randomNumber).experienceGain();
            general.subtractMoney(general.army.get(randomNumber).getValue());
        }
    }

    void execute(General general, Double percentage) {

        Random generator = new Random();

        for (int i = 0; i < general.army.size() * 0.1; i++) {
            int randomNumber = generator.nextInt(general.army.size());
            general.army.get(randomNumber).experienceGain();
            general.subtractMoney(general.army.get(randomNumber).getValue());
        }
    }
}
