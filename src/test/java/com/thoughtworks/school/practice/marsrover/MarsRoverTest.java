package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.E;
import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static com.thoughtworks.school.practice.marsrover.Direction.S;
import static com.thoughtworks.school.practice.marsrover.Direction.W;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thoughtworks.school.practice.marsrover.event.MarsRoverInited;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverMoved;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverTurned;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverTest {

  private MarsRover marsRover;

  @BeforeEach
  void setUp() {
    this.marsRover = new MarsRover();
  }

  @AfterEach
  void tearDown() {
    this.marsRover = null;
  }

  @Test
  void should_inti_mars_rover_success() {
    MarsRoverInited event = marsRover.init(0, 0, N);
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }

  @Test
  void should_make_y_plus_1_when_move_north() {
    MarsRoverInited initEvent = new MarsRoverInited(new Location(0, 0), N);
    marsRover.apply(initEvent);

    MarsRoverMoved event = marsRover.move();
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(1, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }

  @Test
  void should_make_x_minus_1_when_move_west() {
    MarsRoverInited inited = new MarsRoverInited(new Location(0, 0), W);
    marsRover.apply(inited);

    MarsRoverMoved event = marsRover.move();
    marsRover.apply(event);

    assertEquals(-1, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(W, marsRover.getDirection());
  }

  @Test
  void should_make_y_minus_1_when_move_south() {
    MarsRoverInited inited = new MarsRoverInited(new Location(0, 0), S);
    marsRover.apply(inited);

    MarsRoverMoved event = marsRover.move();
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(-1, marsRover.getLocation().getY());
    assertEquals(S, marsRover.getDirection());
  }

  @Test
  void should_make_x_plus_1_when_move_east() {
    MarsRoverInited inited = new MarsRoverInited(new Location(0, 0), E);
    marsRover.apply(inited);

    MarsRoverMoved event = marsRover.move();
    marsRover.apply(event);

    assertEquals(1, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(E, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({
      "N, E",
      "E, S",
      "S, W",
      "W, N"
  })
  void should_turn_right_success(Direction from, Direction to) {
    MarsRoverInited inited = new MarsRoverInited(new Location(0, 0), from);
    marsRover.apply(inited);

    MarsRoverTurned event = marsRover.turnRight();
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(to, marsRover.getDirection());
  }

  @ParameterizedTest
  @CsvSource({
      "N, W",
      "W, S",
      "S, E",
      "E, N"
  })
  void should_turn_left_success(Direction from, Direction to) {
    MarsRoverInited inited = new MarsRoverInited(new Location(0, 0), from);
    marsRover.apply(inited);

    MarsRoverTurned event = marsRover.turnLeft();
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(to, marsRover.getDirection());
  }
}