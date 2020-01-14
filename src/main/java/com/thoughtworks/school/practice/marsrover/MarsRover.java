package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.W;

import com.thoughtworks.school.practice.marsrover.event.MarsRoverInited;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverMoved;

public class MarsRover {

  private Location location;
  private Direction direction;

  public MarsRoverInited init(int locationX, int locationY, Direction direction) {
    return new MarsRoverInited(new Location(locationX, locationY), direction);
  }

  public void apply(MarsRoverInited event) {
    this.location = event.getLocation();
    this.direction = event.getDirection();
  }

  public Location getLocation() {
    return location;
  }

  public Direction getDirection() {
    return direction;
  }

  public MarsRoverMoved move() {
    if (this.direction == N) {
      return new MarsRoverMoved(new Location(location.getX(), location.getY() + 1));
    }
    if (this.direction == W) {
      return new MarsRoverMoved(new Location(location.getX() - 1, location.getY()));
    }
    return null;
  }

  public void apply(MarsRoverMoved event) {
    this.location = event.getEndLocation();
  }
}
