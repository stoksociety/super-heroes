package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import real.Hero;
import spark.utils.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void newHeroInstantiatesCorrectly() {
        new Hero("hulk", "32", "strength", "anger");
        Assert.isTrue(true,"Success");
    }

    @Test
    public void Hero_instantiatesCorrectlyWithHeroName_string () throws Exception{
        Hero hero = new Hero("hulk","34","Strength", "anger");
        assertEquals("hulk",hero.getHeroName());
    }

    @Test
    public void Hero_getsHeroAgeCorrectly_int() throws  Exception {
        Hero hero = new Hero("hulk","34","Strength", "anger");
        assertEquals("34",hero.getHeroAge());
    }

    @Test
    public void Hero_instantiatesCorrectlyWithHeroesSpecialPower_string() throws Exception {
        Hero hero = new Hero("hulk","34","Strength", "anger");
        assertEquals("Strength", hero.getHeroPower());
    }

    @Test
    public void Hero_instantiatesCorrectlyWithHeroWeakness_string() throws Exception{
        Hero hero = new Hero("hulk","34","Strength", "anger");
        assertEquals("anger", hero.getHeroWeakness());
    }

    @Test
    public void all_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("hulk","34","Strength", "anger");
        Hero secondHero = new Hero("hulk","34","Strength", "anger");
        assertEquals(true, Hero.getListOfHeroes().contains(firstHero));
        assertEquals(true, Hero.getListOfHeroes().contains(secondHero));
    }
}
