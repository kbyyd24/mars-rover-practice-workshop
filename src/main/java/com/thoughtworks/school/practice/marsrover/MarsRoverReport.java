package com.thoughtworks.school.practice.marsrover;

public class MarsRoverReport {

  private Position position;
  private Direction direction;

  public MarsRoverReport(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public Position getPosition() {
    return position;
  }

  public Direction getDirection() {
    return direction;
  }
}
