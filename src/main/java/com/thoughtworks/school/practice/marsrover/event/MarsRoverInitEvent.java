package com.thoughtworks.school.practice.marsrover.event;

import com.thoughtworks.school.practice.marsrover.Direction;
import com.thoughtworks.school.practice.marsrover.Location;

public class MarsRoverInitEvent {

  private final Location location;
  private final Direction direction;

  public MarsRoverInitEvent(Location location, Direction direction) {
    this.location = location;
    this.direction = direction;
  }

  public Location getLocation() {
    return location;
  }

  public Direction getDirection() {
    return direction;
  }
}
