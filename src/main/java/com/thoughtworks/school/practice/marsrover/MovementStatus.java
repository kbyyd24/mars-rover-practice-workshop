package com.thoughtworks.school.practice.marsrover;

public enum MovementStatus {
  FORWARD(1), BACKWARD(-1);
  private int movementFactor;

  MovementStatus(int movementFactor) {
    this.movementFactor = movementFactor;
  }

  public int getMovementFactor() {
    return movementFactor;
  }
}
