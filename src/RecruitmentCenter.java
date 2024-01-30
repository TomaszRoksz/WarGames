public class RecruitmentCenter extends Move{
    private final PresidentialSecretary presidentialSecretary;

    public RecruitmentCenter(PresidentialSecretary presidentialSecretary) {
        this.presidentialSecretary= presidentialSecretary;
    }
    @Override
    boolean canExecute(General general){
        return general.getMoney()>100;
    }

    boolean canExecute(General general, Integer numberOfSoldiers, Integer soldiersValue){
        return general.getMoney()>soldiersValue*numberOfSoldiers;
    }

    @Override
    void execute(General general){
        presidentialSecretary.update(general, 10, 1);

        for(int i=0; i<10; i++){
            Soldier soldier = new Soldier(1);
            general.army.add(soldier);
            presidentialSecretary.update(general, soldier, "recruited new soldier.");

        }
    }


    void execute(General general, Integer numberOfSoldiers, Integer soldiersValue) {
        presidentialSecretary.update(general, numberOfSoldiers, soldiersValue);

        for (int i = 0; i < numberOfSoldiers; i++) {
            Soldier soldier = new Soldier(soldiersValue);
            general.army.add(soldier);
            presidentialSecretary.update(general, soldier, "recruited new soldier.");
        }
    }
}
