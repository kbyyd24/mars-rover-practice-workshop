package com.thoughtworks.school.practice.marsrover;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public enum Direction {
  N, E, S, W;

  public static Direction rightOf(Direction source) {
    List<Direction> values = Arrays.stream(values()).collect(toList());
    int rightValueIndex = (values.indexOf(source) + 1) % values.size();
    return values.get(rightValueIndex);
  }

  public static Direction leftOf(Direction source) {
    List<Direction> values = Arrays.stream(values()).collect(toList());
    int leftValueIndex = (values.indexOf(source) + (values.size() - 1)) % values.size();
    return values.get(leftValueIndex);
  }
}
