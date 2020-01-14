package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thoughtworks.school.practice.marsrover.event.MarsRoverInited;
import com.thoughtworks.school.practice.marsrover.event.MarsRoverMoved;
import org.junit.jupiter.api.Test;

class MarsRoverTest {

  @Test
  void should_inti_mars_rover_success() {
    MarsRover marsRover = new MarsRover();

    MarsRoverInited event = marsRover.init(0, 0, N);
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }

  @Test
  void should_make_y_plus_1_when_move_north() {
    MarsRover marsRover = new MarsRover();
    MarsRoverInited initEvent = new MarsRoverInited(new Location(0, 0), N);
    marsRover.apply(initEvent);

    MarsRoverMoved event = marsRover.move();
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(1, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }
}