package real;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }//heroku part
        return 4567;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/",(request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

//      HERO
        post("/new/heroHome", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String heroName = request.queryParams("heroName");
            String heroAge = request.queryParams("heroAge");
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            new Hero(heroName, heroAge, heroPower, heroWeakness);
            return new ModelAndView(model, "heroSuccess.hbs");
        }, new HandlebarsTemplateEngine());

//      getting and displaying the list of heroes in heroList file
        get("/heroList", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getListOfHeroes();
            model.put("hero", heroes);
            return new ModelAndView(model, "heroList.hbs");
        }, new HandlebarsTemplateEngine());

//        SQUAD
        post("/new/squadHome", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            String squadSize = request.queryParams("squadSize");
            String squadCause = request.queryParams("squadCause");
            new Squad(squadName, squadSize, squadCause);
            return new ModelAndView(model, "squadSuccess.hbs");
        }, new HandlebarsTemplateEngine());

//        getting and displaying the list of squads in squadList file
        get("/squadList", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getListOfSquads();
            model.put("squad", squads);
            return new ModelAndView(model, "squadList.hbs");
        },new HandlebarsTemplateEngine());
    }
}