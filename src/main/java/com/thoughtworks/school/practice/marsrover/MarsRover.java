package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Command.B;
import static com.thoughtworks.school.practice.marsrover.Command.F;
import static com.thoughtworks.school.practice.marsrover.Command.L;
import static com.thoughtworks.school.practice.marsrover.Command.R;
import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.S;
import static com.thoughtworks.school.practice.marsrover.Direction.W;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MarsRover {

  private static final Map<Direction, Location> DIRECTION_TO_RELATED_LOCATION = Collections.unmodifiableMap(new HashMap<Direction, Location>() {{
    this.put(N, new Location(0, 1));
    this.put(W, new Location(-1, 0));
    this.put(S, new Location(0, -1));
    this.put(E, new Location(1, 0));
  }});
  private static final Map<Command, Map<Direction, Function<Location, Location>>> MOVE_MAP = Collections
      .unmodifiableMap(new HashMap<Command, Map<Direction, Function<Location, Location>>>() {{
        HashMap<Direction, Function<Location, Location>> forwardMap = new HashMap<Direction, Function<Location, Location>>() {{
          this.put(N, location -> new Location(location.getX(), location.getY() + 1));
          this.put(S, location -> new Location(location.getX(), location.getY() - 1));
          this.put(E, location -> new Location(location.getX() + 1, location.getY()));
          this.put(W, location -> new Location(location.getX() - 1, location.getY()));
        }};
        HashMap<Direction, Function<Location, Location>> backwardMap = new HashMap<Direction, Function<Location, Location>>() {{
          this.put(N, location -> new Location(location.getX(), location.getY() - 1));
          this.put(S, location -> new Location(location.getX(), location.getY() + 1));
          this.put(E, location -> new Location(location.getX() - 1, location.getY()));
          this.put(W, location -> new Location(location.getX() + 1, location.getY()));
        }};
        this.put(F, forwardMap);
        this.put(B, backwardMap);
      }});
  private static final Map<Direction, Direction> TURN_LEFT_MAP = Collections.unmodifiableMap(new HashMap<Direction, Direction>() {{
    this.put(N, W);
    this.put(W, S);
    this.put(S, E);
    this.put(E, N);
  }});
  private static final Map<Direction, Direction> TURN_RIGHT_MAP = Collections.unmodifiableMap(new HashMap<Direction, Direction>() {{
    this.put(N, E);
    this.put(E, S);
    this.put(S, W);
    this.put(W, N);
  }});

  private Location location;
  private Direction direction;
  private final Map<Command, Runnable> commandToAction;

  public MarsRover() {
    this.commandToAction = new HashMap<>();
    commandToAction.put(F, this::forward);
    commandToAction.put(B, this::backward);
    commandToAction.put(L, this::turnLeft);
    commandToAction.put(R, this::turnRight);
  }

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

  public void forward() {
    Location relatedLocation = DIRECTION_TO_RELATED_LOCATION.get(this.direction);
    this.location = this.location.getAbsoluteLocation(relatedLocation);
  }

  public void backward() {
    this.location = MOVE_MAP.get(B).get(this.direction).apply(this.location);
  }

  public void turnLeft() {
    this.direction = TURN_LEFT_MAP.get(this.direction);
  }

  public void turnRight() {
    this.direction = TURN_RIGHT_MAP.get(this.direction);
  }

  public void handleBatch(int initLocationX, int initLocationY, Direction initDirection, Command... commands) {
    this.init(initLocationX, initLocationY, initDirection);
    Arrays.stream(commands).forEach(this::handle);
  }

  private void handle(Command command) {
    this.commandToAction.get(command).run();
  }
}
