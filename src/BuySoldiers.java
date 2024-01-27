public class BuySoldiers extends Move{

    private final int numberOfSoldiers;
    private final int soldiersValue;

    public BuySoldiers(int numberOfSoldiers, int soldiersValue) {
        this.numberOfSoldiers = numberOfSoldiers;
        this.soldiersValue = soldiersValue;
    }
    @Override
    boolean canExecute(General general){
        return general.getMoney()>soldiersValue*numberOfSoldiers;
    }
    @Override
    void execute(General general){

        for(int i=0; i<numberOfSoldiers; i++){
            Soldier soldier = new Soldier(1, soldiersValue);
            general.army.add(soldier);

        }
    }

}
