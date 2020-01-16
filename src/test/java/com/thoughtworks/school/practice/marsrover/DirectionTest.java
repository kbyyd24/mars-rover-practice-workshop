package com.thoughtworks.school.practice.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

  @ParameterizedTest
  @CsvSource({"N, W", "W, S", "S, E", "E, N"})
  void should_get_left_success(Direction from, Direction to) {
    assertEquals(to, from.left());
  }

  @ParameterizedTest
  @CsvSource({"N, E", "E, S", "S, W", "W, N"})
  void should_get_right_success(Direction from, Direction to) {
    assertEquals(to, from.right());
  }
}