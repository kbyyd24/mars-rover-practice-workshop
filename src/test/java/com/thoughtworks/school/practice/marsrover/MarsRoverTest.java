package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thoughtworks.school.practice.marsrover.event.MarsRoverInitEvent;
import org.junit.jupiter.api.Test;

class MarsRoverTest {

  @Test
  void should_inti_mars_rover_success() {
    MarsRover marsRover = new MarsRover();

    MarsRoverInitEvent event = marsRover.init(0, 0, N);
    marsRover.apply(event);

    assertEquals(0, marsRover.getLocation().getX());
    assertEquals(0, marsRover.getLocation().getY());
    assertEquals(N, marsRover.getDirection());
  }
}