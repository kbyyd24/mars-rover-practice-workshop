package com.thoughtworks.school.practice.marsrover.event;

import com.thoughtworks.school.practice.marsrover.Direction;
import com.thoughtworks.school.practice.marsrover.Location;

public class MarsRoverInited implements Event {

  private final Location location;
  private final Direction direction;

  public MarsRoverInited(Location location, Direction direction) {
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
