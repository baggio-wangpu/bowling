package com.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BowlingGameTest {

  @Test
  void should_return_ten_score_when_calculateScore_given_first_ball_kick_all() {

    // given
    BowlingGame game = new BowlingGame();

    // When
    game.startGame(10);

    // then
    assertEquals(10, game.getRoundScore(1));
    assertEquals(10, game.getTotalScore());
  }

  @Test
  void should_return_round1_and_total_score_equal_10_when_calculateScore_given_round1_is_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.startGame(7);
    game.startGame(3);

    // Then
    assertEquals(10, game.getRoundScore(1));
    assertEquals(10, game.getTotalScore());
  }

  @Test
  void should_return_round1_and_total_score_equal_9_when_calculateScore_given_round1_is_not_strike_or_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.startGame(7);
    game.startGame(2);

    // Then
    assertEquals(9, game.getRoundScore(1));
    assertEquals(9, game.getTotalScore());
  }

  @Test
  void should_return_round1_score_and_total_score_equal_2times_round2_score_plus_10_when_calculateScore_given_round1_strike_and_round2_not_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.startGame(10);
    game.startGame(8);
    game.startGame(1);

    // Then
    assertEquals(10 + 9, game.getRoundScore(1));
    assertEquals(2 * 9 + 10, game.getTotalScore());
  }

  @Test
  void should_return_round1_correct_and_total_score_equal_round1_score_plus_round2_throws_when_calculateScore_given_round1_spare_and_round2_not_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.startGame(3);
    game.startGame(7);

    game.startGame(2);
    game.startGame(8);

    // Then
    assertEquals(10 + 2, game.getRoundScore(1));
    assertEquals(game.getRoundScore(1) + 8 + 2, game.getTotalScore());
  }

  @Test
  void should_return_total_score_equal_all_4_throws_when_calculateScore_given_round1_not_spare_and_round2_not_spare() {
    // Given
    BowlingGame game = new BowlingGame();

    // When
    game.startGame(3);
    game.startGame(4);

    game.startGame(6);
    game.startGame(2);

    // Then
    assertEquals(3 + 4 + 6 + 2, game.getTotalScore());
  }

  @Test
  void should_return_round1_score_20_plus_new_throw_when_calculateScore_given_round1_strike_and_round2_strike_then_next_round() {
    // Given
    BowlingGame match = new BowlingGame();

    // When
    match.startGame(10);
    match.startGame(10);
    match.startGame(5);

    // Then
    assertEquals(20 + 5, match.getRoundScore(1));
  }
}
