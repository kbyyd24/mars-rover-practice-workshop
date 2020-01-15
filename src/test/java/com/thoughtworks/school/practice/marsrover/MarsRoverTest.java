package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Command.B;
import static com.thoughtworks.school.practice.marsrover.Command.L;
import static com.thoughtworks.school.practice.marsrover.Command.F;
import static com.thoughtworks.school.practice.marsrover.Command.R;
import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverTest {

  @Test
  void should_init_mars_rover_success() {
    MarsRover marsRover = new MarsRover();

    marsRover.init(0, 0, N);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({
      "N, 0, 1",
      "W, -1, 0",
      "S, 0, -1",
      "E, 1, 0"
  })
  void should_forward_success(Direction direction, int finalX, int finalY) {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, direction);

    marsRover.forward();

    assertEquals(finalX, marsRover.getLocation().getX());
    assertEquals(finalY, marsRover.getLocation().getY());
    assertEquals(direction, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, W", "W, S", "S, E", "E, N"})
  void should_turn_left_success(Direction from, Direction to) {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, from);

    marsRover.turnLeft();

    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, E", "E, S", "S, W", "W, N"})
  void should_turn_right_success(Direction from, Direction to) {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, from);

    marsRover.turnRight();

    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({
      "N, 0, -1",
      "W, 1, 0",
      "S, 0, 1",
      "E, -1, 0"
  })
  void should_handle_backward_success(Direction direction, int finalX, int finalY) {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, direction);

    marsRover.backward();

    assertEquals(finalX, marsRover.getLocation().getX());
    assertEquals(finalY, marsRover.getLocation().getY());
    assertEquals(direction, marsRover.getDirection());
  }

  @Test
  void should_handle_batch_command_success() {
    MarsRover marsRover = new MarsRover();

    marsRover.handleBatch(0, 0, N, F, R, F, R, F, F, B, R, F, L, F, L);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(-1, marsRover.getLocation().getY());
    assertEquals(E, marsRover.getDirection());
  }
}