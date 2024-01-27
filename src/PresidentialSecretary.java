import java.util.HashMap;
import java.util.Map;

class PresidentialSecretary{
    private General general;
    private HashMap <Move, Observer> observers;

    public void observe (Move move, Observer observer){
        observers.put(move, observer);
    }

    public void unObserve (Move move, Observer observer){
        observers.remove(move, observer);
    }

    public void notify(Move move, Observer observer){
        observers.forEach((key, value) -> {
            value.update(general);
        });

        }
    }
