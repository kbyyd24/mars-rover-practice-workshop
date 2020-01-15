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

  private static final Map<Direction, Function<Command, Function<Location, Location>>> MOVE_MAP = Collections
      .unmodifiableMap(new HashMap<Direction, Function<Command, Function<Location, Location>>>() {{
        this.put(N, command -> location -> new Location(location.getX(), location.getY() + command.getAmmountOfMovement()));
        this.put(S, command -> location -> new Location(location.getX(), location.getY() - command.getAmmountOfMovement()));
        this.put(E, command -> location -> new Location(location.getX() + command.getAmmountOfMovement(), location.getY()));
        this.put(W, command -> location -> new Location(location.getX() - command.getAmmountOfMovement(), location.getY()));
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
    this.location = move(F);
  }

  public void backward() {
    this.location = move(B);
  }

  private Location move(Command command) {
    return MOVE_MAP.get(this.direction).apply(command).apply(this.location);
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
