package com.thoughtworks.school.practice.marsrover;

public enum Command {
  L(0), R(0), F(1), B(-1);
  private int ammountOfMovement;

  Command(int ammountOfMovement) {
    this.ammountOfMovement = ammountOfMovement;
  }

  public int getAmmountOfMovement() {
    return ammountOfMovement;
  }
}
