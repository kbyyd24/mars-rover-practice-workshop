package com.thoughtworks.school.practice.marsrover.event;

import com.thoughtworks.school.practice.marsrover.Location;

public class MarsRoverMoved {

  private final Location endLocation;

  public MarsRoverMoved(Location endLocation) {
    this.endLocation = endLocation;
  }

  public Location getEndLocation() {
    return endLocation;
  }
}
