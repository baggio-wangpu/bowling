package com.bowling;

import java.util.ArrayList;

public class BowlingGame {

  public BowlingGame() {
    currentRound = 0;
    rounds = new ArrayList<>();
    initializeRound();
  }

  public void startGame(int score) {
    boolean isFinished = false;
    if(currentRound < TOTAL_ROUNDS) {
      isFinished = rounds.get(currentRound).startRound(score);
    }

    updateStatus(currentRound - 1, score);
    updateStatus(currentRound - 2, score);

    if(isFinished) {
      currentRound++;
    }
  }

  public int getTotalScore() {
    return rounds.stream().mapToInt(Round::getScore).sum();
  }

  public int getRoundScore(int round) {
    return rounds.get(round-1).getScore();
  }

  private void updateStatus(int roundIndex, int score) {
    if(roundIndex >= 0 && roundIndex < rounds.size()) {
      rounds.get(roundIndex).updateScoreWithNextThrow(score);
    }
  }

  private void initializeRound() {
    for (int i = 0; i < TOTAL_ROUNDS; i++) {
      rounds.add(new Round());
    }
  }

  private static final int TOTAL_ROUNDS = 10;
  private int currentRound;
  private ArrayList<Round> rounds;

}
