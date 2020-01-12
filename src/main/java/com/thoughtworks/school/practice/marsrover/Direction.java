package com.thoughtworks.school.practice.marsrover;

public enum Direction {
  N, E, S, W;

  public Position move(Position previousPosition) {
    if (this == N) {
      return previousPosition.moveY(1);
    }
    if (this == E) {
      return previousPosition.moveX(1);
    }
    if (this == S) {
      return previousPosition.moveY(-1);
    }
    if (this == W) {
      return previousPosition.moveX(-1);
    }
    return null;
  }
}
