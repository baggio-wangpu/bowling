import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {

  @Test
  void should_return_ten_score_when_caculateScore_given_first_ball_kick_all() {

    //given
    String givenStr = "X|";
    BowlingGame bowlingGame = new BowlingGame();

    //when
    int actualScore = bowlingGame.caculateScore(givenStr);

    //then
    assertEquals(10, actualScore);
  }
}
