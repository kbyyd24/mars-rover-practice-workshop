package com.thoughtworks.school.practice.marsrover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  void should_return_new_position_when_move_x() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = previousPosition.moveX(1);

    assertEquals(1, newPosition.getX());
    assertEquals(0, newPosition.getY());
  }

  @Test
  void should_return_new_position_when_move_y() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = previousPosition.moveY(1);

    assertEquals(0, newPosition.getX());
    assertEquals(1, newPosition.getY());

  }
}