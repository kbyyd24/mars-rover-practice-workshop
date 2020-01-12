package com.thoughtworks.school.practice.marsrover;

public class MarsRover {

  private Position position;
  private Direction direction;

  public MarsRover(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public static MarsRoverReport handle(int positionX, int positionY, Direction direction) {
    MarsRover marsRover = new MarsRover(new Position(positionX, positionY), direction);
    return marsRover.report();
  }

  private MarsRoverReport report() {
    return new MarsRoverReport(this.position, this.direction);
  }

}
