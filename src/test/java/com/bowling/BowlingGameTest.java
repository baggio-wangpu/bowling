package com.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BowlingGameTest {

  @Test
  void should_return_ten_score_when_caculateScore_given_first_ball_kick_all() {

    // given
    BowlingGame game = new BowlingGame();

    // When
    game.recordThrow(10);

    // then
    assertEquals(10, game.getRoundScore(1));
    assertEquals(10, game.getTotalScore());
  }

  @Test
  void should_have_round1_and_total_score_equal_10_when_record_throw_given_round1_is_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.recordThrow(7);
    game.recordThrow(3);

    // Then
    assertEquals(10, game.getRoundScore(1));
    assertEquals(10, game.getTotalScore());
  }

  @Test
  void should_have_round1_and_total_score_equal_9_when_record_throw_given_round1_is_not_strike_or_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.recordThrow(7);
    game.recordThrow(2);

    // Then
    assertEquals(9, game.getRoundScore(1));
    assertEquals(9, game.getTotalScore());
  }

  @Test
  void should_have_round1_equal_10_plus_round2_score_and_total_score_equal_2times_round2_score_plus_10_when_record_throw_given_round1_strike_and_round2_not_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.recordThrow(10);
    game.recordThrow(8);
    game.recordThrow(1);

    // Then
    assertEquals(10 + 9, game.getRoundScore(1));
    assertEquals(2 * 9 + 10, game.getTotalScore());
  }

  @Test
  void should_have_round1_equal_10_plus_round2_first_throw_and_total_score_equal_round1_score_plus_round2_throws_when_record_throw_given_round1_spare_and_round2_not_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.recordThrow(5);
    game.recordThrow(5);

    game.recordThrow(8);
    game.recordThrow(1);

    // Then
    assertEquals(10 + 8, game.getRoundScore(1));
    assertEquals(game.getRoundScore(1) + 8 + 1, game.getTotalScore());
  }

  @Test
  void should_have_total_score_equal_all_4_throws_when_record_throw_given_round1_not_spare_and_round2_not_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.recordThrow(5);
    game.recordThrow(3);

    game.recordThrow(8);
    game.recordThrow(1);

    // Then
    assertEquals(5 + 3 + 8 + 1, game.getTotalScore());
  }
}
