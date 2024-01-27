public class AttackObserver implements Observer {
    private General attackedGeneral;
    private boolean win;
    WriteToFile file;

//    public AttackObserver(General general, boolean win, WriteToFile file){
//
//    }

    @Override
    public void update(General general) {

        file.writeToFile("General" );
    }
}