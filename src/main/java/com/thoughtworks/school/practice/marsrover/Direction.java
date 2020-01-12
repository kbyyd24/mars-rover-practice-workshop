package com.thoughtworks.school.practice.marsrover;

public enum Direction {
  N {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveY(1);
    }
  }, E {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveX(1);
    }
  }, S {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveY(-1);
    }
  }, W {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveX(-1);
    }
  };

  abstract public Position move(Position previousPosition);

}
