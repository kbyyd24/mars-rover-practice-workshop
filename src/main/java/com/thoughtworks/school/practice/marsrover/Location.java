package com.thoughtworks.school.practice.marsrover;

public class Location {

  private int x;
  private int y;

  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Location getAbsoluteLocation(Location relatedLocation) {
    return new Location(this.x + relatedLocation.x, this.y + relatedLocation.y);
  }
}
