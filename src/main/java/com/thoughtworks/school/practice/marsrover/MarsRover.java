package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.W;

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
    if (direction == N) {
      this.location = this.location.getAbsoluteLocation(new Location(0, 1));
    }
    if (direction == W) {
      this.location = this.location.getAbsoluteLocation(new Location(-1, 0));
    }
  }
}
