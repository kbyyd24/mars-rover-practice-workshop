package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.S;
import static com.thoughtworks.school.practice.marsrover.Direction.W;
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

  @Test
  void should_make_y_plus_1_when_move_and_direction_is_north() {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, N);

    marsRover.move();

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(1, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }

  @Test
  void should_make_x_minus_1_when_move_and_direction_is_west() {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, W);

    marsRover.move();

    assertEquals(-1, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(W, marsRover.getDirection());
  }

  @Test
  void should_make_y_minus_1_when_move_and_direction_is_south() {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, S);

    marsRover.move();

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(-1, marsRover.getLocation().getY());
    assertEquals(S, marsRover.getDirection());
  }

  @Test
  void should_make_x_plus_1_when_move_and_direction_is_east() {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, E);

    marsRover.move();

    assertEquals(1, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(E, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({"N, W", "W, S", "S, E", "E, N"})
  void should_turn_left_success(Direction from, Direction to) {
    MarsRover marsRover = new MarsRover();
    marsRover.init(0, 0, from);

    marsRover.turn(Command.L);

    assertEquals(to, marsRover.getDirection());
  }
}