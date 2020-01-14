package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Command.L;
import static com.thoughtworks.school.practice.marsrover.Command.M;
import static com.thoughtworks.school.practice.marsrover.Command.R;
import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.S;
import static com.thoughtworks.school.practice.marsrover.Direction.W;

import com.thoughtworks.school.practice.marsrover.event.Event;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverInited;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverMoved;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverTurned;
import java.util.Arrays;
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

  public MarsRoverTurned turnRight() {
    return new MarsRoverTurned(Direction.rightOf(this.direction));
  }

  public void apply(MarsRoverTurned event) {
    this.direction = event.getDirection();
  }

  public MarsRoverTurned turnLeft() {
    return new MarsRoverTurned(Direction.leftOf(this.direction));
  }

  public void handle(int initX, int initY, Direction initDirection, Command... commands) {
    MarsRoverInited inited = this.init(initX, initY, initDirection);
    this.apply(inited);
    Arrays.stream(commands).map(this::handle).forEach(event -> {
      if (event instanceof MarsRoverMoved) {
        this.apply((MarsRoverMoved) event);
      }
      if (event instanceof MarsRoverTurned) {
        this.apply((MarsRoverTurned) event);
      }
    });
  }

  private Event handle(Command command) {
    if (command == M) {
      return this.move();
    }
    if (command == L) {
      return this.turnLeft();
    }
    if (command == R) {
      return this.turnRight();
    }
    return null;
  }
}
