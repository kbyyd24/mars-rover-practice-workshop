package com.thoughtworks.school.practice.marsrover;

public class MarsRover {

  private Position position;
  private Direction direction;

  public MarsRover(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public static MarsRoverReport handle(int positionX, int positionY, Direction direction, String moveCommand) {
    MarsRover marsRover = new MarsRover(new Position(positionX, positionY), direction);
    moveCommand.chars()
        .mapToObj(i -> (char) i)
        .forEach(marsRover::handle);
    return marsRover.report();
  }

  private void handle(Character command) {
    if (command == 'M') {
      this.move();
    } else if (command == 'L' || command == 'R') {
      this.turn(command);
    }
  }

  private void turn(Character command) {
    TurnDirection turnDirection = TurnDirection.valueOf(String.valueOf(command));
    this.direction = this.direction.turn(turnDirection);
  }

  private void move() {
    this.position = this.direction.move(this.position);
  }

  private MarsRoverReport report() {
    return new MarsRoverReport(this.position, this.direction);
  }

}
