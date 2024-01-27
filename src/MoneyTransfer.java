public class MoneyTransfer extends Move{
    private final double moneyAmount;
    private final General currentGeneral;

    public MoneyTransfer(double moneyAmount, General currentGeneral) {
        this.moneyAmount = moneyAmount;
        this.currentGeneral = currentGeneral;
    }

    @Override
    boolean canExecute(General general){
        return currentGeneral.getMoney()>moneyAmount;
    }

    @Override
    void execute(General general){
       general.addMoney(moneyAmount);
       currentGeneral.substractMoney(moneyAmount);
    }

}
