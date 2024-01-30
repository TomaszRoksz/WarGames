public class PresidentialSecretary implements Observer {

    WriteToFile file;

    PresidentialSecretary(String file){
        this.file=new WriteToFile(file);
    }

    @Override
    public void update(Object o) {

    }

    public void update(General general, General attackedGeneral, String result) {

        file.writeToFile("General "+ general.getName()+" attacked general "+ attackedGeneral+" and "+result);
    }

    public void update(General general, Integer numberOfSoldiers, Integer soldiersValue) {

        file.writeToFile("General "+general.getName()+" recruited "+numberOfSoldiers+" soldiers for "+soldiersValue+" golden coins each.");
    }

    public void update(General general, Double percentage) {

        file.writeToFile("General "+general.getName()+" sent "+percentage+" of his soldiers for maneuvers.");
    }

    public void update(General general, Soldier soldier, String action) {

        file.writeToFile("Soldier "+soldier+" from general "+general.getName()+" army "+action);
    }


}