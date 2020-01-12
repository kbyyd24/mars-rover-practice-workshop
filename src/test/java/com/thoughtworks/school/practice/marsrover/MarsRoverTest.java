package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.Direction.N;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MarsRoverTest {

  @Test
  void should_receive_init_command_to_init_mars_rover() {
    MarsRoverReport report = MarsRover.handle(0, 0, N, "");

    assertEquals(0, report.getPosition().getX());
    assertEquals(0, report.getPosition().getY());
    assertEquals(N, report.getDirection());
  }

  @Test
  void should_receive_command_and_move_mars_rover() {
    MarsRoverReport report = MarsRover.handle(0, 0, N, "MM");

    assertEquals(0, report.getPosition().getX());
    assertEquals(2, report.getPosition().getY());
    assertEquals(N, report.getDirection());
  }
}