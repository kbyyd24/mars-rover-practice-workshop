package com.thoughtworks.school.practice.marsrover;

import java.util.Arrays;

public enum Direction {
  N(0), W(1), S(2), E(3);
  private static final int STEP = 1;
  private int order;

  Direction(int order) {
    this.order = order;
  }

  public Direction left() {
    int leftOrder = (this.order + STEP) % values().length;
    return Arrays.stream(values()).filter(direction -> direction.order == leftOrder).findFirst().orElseThrow(IllegalStateException::new);
  }

  public Direction right() {
    int leftOrder = (this.order + values().length - STEP) % values().length;
    return Arrays.stream(values()).filter(direction -> direction.order == leftOrder).findFirst().orElseThrow(IllegalStateException::new);
  }

}
