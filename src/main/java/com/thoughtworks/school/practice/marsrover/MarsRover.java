package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.S;
import static com.thoughtworks.school.practice.marsrover.Direction.W;

import com.thoughtworks.school.practice.marsrover.event.MarsRoverInited;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverMoved;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MarsRover {

  private final static Map<Direction, Function<Location, Location>> MOVE_MAP = new HashMap<Direction, Function<Location, Location>>() {{
    this.put(N, location -> new Location(location.getX(), location.getY() + 1));
    this.put(W, location -> new Location(location.getX() - 1, location.getY()));
    this.put(S, location -> new Location(location.getX(), location.getY() - 1));
    this.put(E, location -> new Location(location.getX() + 1, location.getY()));
  }};

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
    return new MarsRoverMoved(MOVE_MAP.get(this.direction).apply(this.location));
  }

  public void apply(MarsRoverMoved event) {
    this.location = event.getEndLocation();
  }
}
