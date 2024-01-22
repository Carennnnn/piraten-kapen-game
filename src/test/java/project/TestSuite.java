package project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project.acceptanceTest.Part1AcceptanceTest;
import project.acceptanceTest.Part2AcceptanceTest;
import project.unitTest.CardUnitTest;
import project.unitTest.DiceUnitTest;
import project.unitTest.PlayerServerUnitTest;
import project.unitTest.ScoreUnitTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
      Part1AcceptanceTest.class,
      Part2AcceptanceTest.class,
      CardUnitTest.class,
      DiceUnitTest.class,
      PlayerServerUnitTest.class,
      ScoreUnitTest.class
})

public class TestSuite {

}