package com.thoughtworks.school.practice.marsrover;

public enum Direction {
  N, E, S, W;

  public Position move(Position previousPosition) {
    if (this == N) {
      return new Position(previousPosition.getX(), previousPosition.getY() + 1);
    }
    return null;
  }
}
