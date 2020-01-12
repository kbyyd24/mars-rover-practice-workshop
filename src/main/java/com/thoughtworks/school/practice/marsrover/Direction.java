package com.thoughtworks.school.practice.marsrover;

public enum Direction {
  N, E, S, W;

  public Position move(Position previousPosition) {
    if (this == N) {
      return new Position(previousPosition.getX(), previousPosition.getY() + 1);
    }
    if (this == E) {
      return new Position(previousPosition.getX() + 1, previousPosition.getY());
    }
    if (this == S) {
      return new Position(previousPosition.getX(), previousPosition.getY() - 1);
    }
    return null;
  }
}
