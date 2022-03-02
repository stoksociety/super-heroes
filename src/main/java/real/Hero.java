package real;


import java.util.ArrayList;

public class Hero {
    private final String heroName;
    private final String heroAge;
    private final String heroPower;
    private final String heroWeakness;

    private static ArrayList<Hero> listOfHeroes = new ArrayList<Hero>();
    private final int id;

    public Hero(String heroName, String heroAge, String heroPower, String heroWeakness) {
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.heroPower = heroPower;
        this.heroWeakness = heroWeakness;
        listOfHeroes.add(this);
        this.id = listOfHeroes.size();
    }



    public String getHeroName() {
        String heroName = this.heroName;
        return heroName;
    }

    public String getHeroAge() {
        String heroAge = this.heroAge;
        return heroAge;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public static ArrayList<Hero> getListOfHeroes() {
        return listOfHeroes;
    }

    public int getId() {
        return id;
    }

    public static Hero findById(int id){
        return listOfHeroes.get(id - 1);
    }

    public static void cleaerAllPosts(){
        listOfHeroes.clear();
    }
}