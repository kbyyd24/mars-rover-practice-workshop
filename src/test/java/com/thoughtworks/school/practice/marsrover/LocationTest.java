package com.thoughtworks.school.practice.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocationTest {

  @Test
  void should_get_absolute_location_when_given_a_related_location() {
    Location current = new Location(1, 4);
    Location related = new Location(1, -1);

    Location absoluteLocation = current.getAbsoluteLocation(related);

    assertEquals(2, absoluteLocation.getX());
    assertEquals(3, absoluteLocation.getY());
  }
}