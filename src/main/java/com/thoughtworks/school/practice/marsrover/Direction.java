package com.thoughtworks.school.practice.marsrover;

import static com.thoughtworks.school.practice.marsrover.TurnDirection.L;
import static com.thoughtworks.school.practice.marsrover.TurnDirection.R;

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
      if (turnDirection == R) {
        return E;
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
      if (turnDirection == R) {
        return S;
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
      if (turnDirection == R) {
        return W;
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
      if (turnDirection == R) {
        return N;
      }
      return null;
    }
  };

  abstract public Position move(Position previousPosition);

  abstract public Direction turn(TurnDirection turnDirection);
}
