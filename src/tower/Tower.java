package tower;

import flyable.Flyable;

import java.util.ArrayList;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> unregistered = new ArrayList<>();

    public  void register(Flyable flyable){
        if (observers.contains(flyable))
            return ;
        else
            observers.add(flyable);

    }

    public void unregister(Flyable flyable){
        if (unregistered.contains(flyable))
            return ;
        else
            unregistered.add(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable flyable: observers)
        {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    }

}
