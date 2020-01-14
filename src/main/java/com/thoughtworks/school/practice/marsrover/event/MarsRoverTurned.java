package com.thoughtworks.school.practice.marsrover.event;

import com.thoughtworks.school.practice.marsrover.Direction;

public class MarsRoverTurned {
  private final Direction direction;

  public MarsRoverTurned(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }
}
