package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Command.L;
import static com.thoughtworks.school.practice.marsrover.Command.M;
import static com.thoughtworks.school.practice.marsrover.Command.R;
import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverTest {

  private MarsRover marsRover;

  @BeforeEach
  void setUp() {
    marsRover = new MarsRover();
  }

  @AfterEach
  void tearDown() {
    marsRover = null;
  }

  @Test
  void should_init_mars_rover_success() {
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
    marsRover.init(0, 0, direction);

    marsRover.move();

    assertEquals(finalX, marsRover.getLocation().getX());
    assertEquals(finalY, marsRover.getLocation().getY());
    assertEquals(direction, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, W", "W, S", "S, E", "E, N"})
  void should_turn_left_success(Direction from, Direction to) {
    marsRover.init(0, 0, from);

    marsRover.turnLeft();

    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, E", "E, S", "S, W", "W, N"})
  void should_turn_right_success(Direction from, Direction to) {
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
  void should_move_back_when_mars_rover_is_in_backwarding_status(Direction direction, int finalX, int finalY) {
    marsRover.init(0, 0, direction);
    marsRover.toBackwarding();

    marsRover.move();

    assertEquals(finalX, marsRover.getLocation().getX());
    assertEquals(finalY, marsRover.getLocation().getY());
    assertEquals(direction, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, W", "W, S", "S, E", "E, N"})
  void should_turn_left_when_turn_right_and_mars_rover_is_in_backwarding_status(Direction from, Direction to) {
    marsRover.init(0, 0, from);
    marsRover.toBackwarding();

    marsRover.turnRight();

    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, E", "E, S", "S, W", "W, N"})
  void should_turn_right_when_turn_left_and_mars_rover_is_in_backwarding_status(Direction from, Direction to) {
    marsRover.init(0, 0, from);
    marsRover.toBackwarding();

    marsRover.turnLeft();

    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({
      "N, 0, 1",
      "W, -1, 0",
      "S, 0, -1",
      "E, 1, 0"
  })
  void should_forward_success_when_rover_status_turn_to_forwarding(Direction direction, int finalX, int finalY) {
    marsRover.init(0, 0, direction);
    marsRover.toBackwarding();
    marsRover.toForwarding();

    marsRover.move();

    assertEquals(finalX, marsRover.getLocation().getX());
    assertEquals(finalY, marsRover.getLocation().getY());
    assertEquals(direction, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, W", "W, S", "S, E", "E, N"})
  void should_turn_left_success_when_rover_status_turn_to_forwarding(Direction from, Direction to) {
    marsRover.init(0, 0, from);
    marsRover.toBackwarding();
    marsRover.toForwarding();

    marsRover.turnLeft();

    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, E", "E, S", "S, W", "W, N"})
  void should_turn_right_success_when_rover_status_turn_to_forwarding(Direction from, Direction to) {
    marsRover.init(0, 0, from);
    marsRover.toBackwarding();
    marsRover.toForwarding();

    marsRover.turnRight();

    assertEquals(to, marsRover.getDirection());
  }

  @Test
  void should_handle_batch_command_success() {
    marsRover.handleBatch(0, 0, N, M, R, M, R, M, M, M, R, M, L, M, L);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(-3, marsRover.getLocation().getY());
    assertEquals(E, marsRover.getDirection());
  }
}