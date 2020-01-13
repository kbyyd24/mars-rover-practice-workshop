package com.thoughtworks.school.practice.marsrover;

public class MarsRover {

  private Location location;
  private Direction direction;

  public void init(int locationX, int locationY, Direction direction) {
    this.location = new Location(locationX, locationY);
    this.direction = direction;
  }

  public Location getLocation() {
    return location;
  }

  public Direction getDirection() {
    return direction;
  }

  public void move() {
    this.location = new Location(this.location.getX(), this.location.getY() + 1);
  }
}
