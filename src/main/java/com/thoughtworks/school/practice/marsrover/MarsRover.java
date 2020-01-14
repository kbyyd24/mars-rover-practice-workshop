package com.thoughtworks.school.practice.marsrover;

import com.thoughtworks.school.practice.marsrover.event.MarsRoverInitEvent;

public class MarsRover {

  private Location location;
  private Direction direction;

  public MarsRoverInitEvent init(int locationX, int locationY, Direction direction) {
    return new MarsRoverInitEvent(new Location(locationX, locationY), direction);
  }

  public void apply(MarsRoverInitEvent event) {
    this.location = event.getLocation();
    this.direction = event.getDirection();
  }

  public Location getLocation() {
    return location;
  }

  public Direction getDirection() {
    return direction;
  }
}
