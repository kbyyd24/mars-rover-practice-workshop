package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.S;
import static com.thoughtworks.school.practice.marsrover.Direction.W;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {

  private static final Map<Direction, Location> DIRECTION_TO_RELATED_LOCATION = Collections.unmodifiableMap(new HashMap<Direction, Location>() {{
    this.put(N, new Location(0, 1));
    this.put(W, new Location(-1, 0));
    this.put(S, new Location(0, -1));
    this.put(E, new Location(1, 0));
  }});

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
    Location relatedLocation = DIRECTION_TO_RELATED_LOCATION.get(this.direction);
    this.location = this.location.getAbsoluteLocation(relatedLocation);
  }
}
