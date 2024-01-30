public class MoneyTransfer extends Move{
    private final double percentage;
    private final General currentGeneral;

    public MoneyTransfer(double percentage, General currentGeneral) {
        this.percentage = percentage;
        this.currentGeneral = currentGeneral;
    }

    @Override
    boolean canExecute(General general){

        return currentGeneral.getMoney()*percentage>general.getMoney();
    }

    @Override
    void execute(General general){

       double moneyAmount = currentGeneral.getMoney()*percentage;

       general.addMoney(moneyAmount);
       currentGeneral.subtractMoney(moneyAmount);
    }

}
