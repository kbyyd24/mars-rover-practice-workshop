package com.thoughtworks.school.practice.marsrover;

public class Position {

  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Position moveX(int move) {
    return new Position(x + move, y);
  }

  public Position moveY(int move) {
    return new Position(x, y + move);
  }
}
