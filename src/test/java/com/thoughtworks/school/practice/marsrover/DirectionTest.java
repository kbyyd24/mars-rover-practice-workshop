package com.thoughtworks.school.practice.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionTest {

  @Test
  void should_return_new_position_with_plus_1_y_when_north_move() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = Direction.N.move(previousPosition);

    assertEquals(1, newPosition.getY() - previousPosition.getY());
  }

  @Test
  void should_return_new_position_with_plus_1_x_when_east_move() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = Direction.E.move(previousPosition);

    assertEquals(1, newPosition.getX() - previousPosition.getX());
  }

  @Test
  void should_return_new_position_with_minus_1_y_when_south_move() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = Direction.S.move(previousPosition);

    assertEquals(-1, newPosition.getY() - previousPosition.getY());
  }

  @Test
  void should_return_new_position_with_minus_1_x_when_west_move() {
    Position previousPosition = new Position(0, 0);

    Position newPosition = Direction.W.move(previousPosition);

    assertEquals(-1, newPosition.getX() - previousPosition.getX());
  }

  @Test
  void should_turn_to_west_when_north_turn_left() {
    Direction west = Direction.N.turn(TurnDirection.L);

    assertEquals(Direction.W, west);
  }

  @Test
  void should_turn_to_south_when_west_turn_left() {
    Direction south = Direction.W.turn(TurnDirection.L);

    assertEquals(Direction.S, south);
  }

  @Test
  void should_turn_to_east_when_south_turn_left() {
    Direction east = Direction.S.turn(TurnDirection.L);

    assertEquals(Direction.E, east);
  }
}