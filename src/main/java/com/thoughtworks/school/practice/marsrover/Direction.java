package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.TurnDirection.L;

public enum Direction {
  N {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveY(1);
    }

    @Override
    public Direction turn(TurnDirection turnDirection) {
      if (turnDirection == L) {
        return W;
      }
      return null;
    }
  },
  E {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveX(1);
    }

    @Override
    public Direction turn(TurnDirection turnDirection) {
      if (turnDirection == L) {
        return N;
      }
      return null;
    }
  },
  S {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveY(-1);
    }

    @Override
    public Direction turn(TurnDirection turnDirection) {
      if (turnDirection == L) {
        return E;
      }
      return null;
    }
  },
  W {
    @Override
    public Position move(Position previousPosition) {
      return previousPosition.moveX(-1);
    }

    @Override
    public Direction turn(TurnDirection turnDirection) {
      if (turnDirection == L) {
        return S;
      }
      return null;
    }
  };

  abstract public Position move(Position previousPosition);

  abstract public Direction turn(TurnDirection turnDirection);
}
