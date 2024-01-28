import java.util.Random;

class AttackHandler extends Move {

    public General attackedGeneral;
    private final PresidentialSecretary presidentialSecretary;

    AttackHandler(General attackedGeneral, PresidentialSecretary presidentialSecretary) {
        this.attackedGeneral = attackedGeneral;
        this.presidentialSecretary = presidentialSecretary;
    }

    @Override
    boolean canExecute(General general){
        return general.getArmyPower()>0 && general.getMoney()>0;
    }
    @Override
    void execute(General general){
        if(canExecute(general)) {
            Integer armyPower1 = general.getArmyPower();
            Integer armyPower2 = attackedGeneral.getArmyPower();
            if (armyPower1 > armyPower2) {
                presidentialSecretary.update(general, attackedGeneral, "won");
                battleWin(general);
                battleLoss(attackedGeneral);
            } else if (armyPower1 < armyPower2) {
                presidentialSecretary.update(general, attackedGeneral, "lost");
                battleWin(attackedGeneral);
                battleLoss(general);
            } else {
                presidentialSecretary.update(general, attackedGeneral, "it was a draw");
                battleDraw(general);
                battleDraw(attackedGeneral);
            }
        }
    }

    void battleLoss(General general) {

        Random generator = new Random();

        for (int i = 0; i < (general.army.size() / 10); i++) {
            general.army.remove(generator.nextInt(general.army.size()));
        }

        for (Soldier soldier : general.army) {
            soldier.experienceLoss();
            if (soldier.getExperience() == 0) {
                general.army.remove(soldier);
            }
        }
    }

    void battleWin(General general){

        for(Soldier soldier:general.army) {
            soldier.experienceGain();
        }

    }

    void battleDraw(General general){
        Random generator = new Random();

        for(int i = 0; i <= 1; i++) {
            general.army.remove(generator.nextInt(general.army.size()));    }
    }
}
