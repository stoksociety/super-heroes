package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import real.Squad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquadTest {
    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void SquadInstantiatesCorrectly() throws Exception {
        Squad squad = new Squad("flash", "9", "Save us");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void Squad_getsSquadNameCorrectly_string() throws Exception{
        Squad squad = new Squad("flash", "9", "Save us");
        assertEquals("Avengers", squad.getSquadName());
    }

    @Test
    public void Squad_getsMaxSizeCorrectly_int() throws Exception{
        Squad squad = new Squad("flash", "9", "Save us");
        assertEquals("10", squad.getSquadSize());
    }

    @Test
    public void Squad_getsSquadsNameCorrectly() throws Exception {
        Squad squad = new Squad("flash", "9", "Save us");
        assertEquals("Save America", squad.getSquadCause());
    }

    @Test
    public void all_returnsAllInstancesOfSquad_true() throws Exception {
        Squad firstSquad = new Squad("flash", "9", "save us");
        Squad secondSquad = new Squad("SuperMan", "15", "fight-corruption");
        assertTrue(Squad.getListOfSquads().contains(firstSquad));
        assertTrue(Squad.getListOfSquads().contains(secondSquad));
    }

    @Test
    public void find_returnsSquadWithSameId_secondSquad() {
        Squad firstSquad = new Squad("flash", "9", "Save us");
        Squad secondSquad = new Squad("SuperMan", "15", "fight-corruption");
        assertEquals(Squad.find(secondSquad.getId()), secondSquad);
    }

}
