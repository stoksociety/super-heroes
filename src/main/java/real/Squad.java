package real;

import java.util.ArrayList;

public class Squad {
    private String squadName;
    private String squadSize;
    private String squadCause;

    private static ArrayList<Squad> listOfSquads = new ArrayList<Squad>();
    private int id;

    public Squad(String squadName, String squadSize, String squadCause) {
        this.squadName = squadName;
        this.squadSize = squadSize;
        this.squadCause = squadCause;
        listOfSquads.add(this);
        this.id = listOfSquads.size();
    }

    public String getSquadName() {
        return squadName;
    }

    public String getSquadSize() {

        return squadSize;
    }

    public String getSquadCause() {

        return squadCause;
    }

    public static ArrayList<Squad> getListOfSquads() {
        return listOfSquads;
    }

    public int getId() {
        return id;
    }

    public static Squad find(int id){
        return listOfSquads.get(id - 1);
    }
}
