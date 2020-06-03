package com.bowling;

class Round {

  int getScore() {
    return score;
  }

  boolean startRound(int score) {
    calculateScore(score);
    this.score = firstGame + (secondGame < 0 ? 0 : secondGame);
    if(this.score == 10) {
      additionalGamesCount++;
    }

    return firstGame == 10 || secondGame > -1;
  }

  void updateScoreWithNextThrow(int score) {
    if(additionalGamesCount > 0) {
      this.score += score;
      additionalGamesCount--;
    }
  }

  private void calculateScore(int score) {
    if (firstGame == -1) {
      firstGame = score;
      if(firstGame == 10) {
        additionalGamesCount++;
      }
    } else {
      secondGame = score;
    }
  }

  private int score = 0;
  private int firstGame = -1;
  private int secondGame = -1;
  private int additionalGamesCount = 0;
}
