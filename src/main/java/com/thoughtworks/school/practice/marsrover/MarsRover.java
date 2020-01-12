package com.thoughtworks.school.practice.marsrover;

import java.util.Arrays;
import java.util.stream.Stream;

public class MarsRover {

  private Position position;
  private Direction direction;

  public MarsRover(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public static MarsRoverReport handle(int positionX, int positionY, Direction direction, String moveCommand) {
    MarsRover marsRover = new MarsRover(new Position(positionX, positionY), direction);
    for (int i = 0; i < moveCommand.length(); i++) {
      marsRover.move();
    }
    return marsRover.report();
  }

  private void move() {
    this.position = this.direction.move(this.position);
  }

  private MarsRoverReport report() {
    return new MarsRoverReport(this.position, this.direction);
  }

}
