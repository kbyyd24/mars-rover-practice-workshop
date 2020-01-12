package com.thoughtworks.school.practice.marsrover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void should_return_new_position_with_plus_1_y_when_north_move() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = Direction.N.move(previousPosition);

    assertEquals(1, newPosition.getY() - previousPosition.getY());
  }
}