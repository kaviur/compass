package com.epam.rd.autotasks;

import java.util.Optional;

import static java.lang.Math.abs;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);


    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public int getDegrees() {
        return degrees;
    }

    public int upperAndLessCase (int degrees){
        while (degrees >= 360 ){
            degrees -= 360;
        }
        if( degrees < 0 ){
            degrees = 360 + degrees;
        }
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        if( degrees < 0 || degrees >= 360 ){
            degrees = E.upperAndLessCase(degrees);
        }

        for (Direction dir : Direction.values() ) {
            if( dir.getDegrees() == degrees ){
                return dir;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        if( degrees < 0 || degrees >= 360 ){
            degrees = E.upperAndLessCase(degrees);
        }

        int min = 360;
        Direction direction = Direction.N;

        for (Direction dir : Direction.values() ) {
            int diference = abs(dir.getDegrees() - degrees);
            if( diference <= min ){
                min = diference;
                direction = dir;
            }
        }
        return direction;
    }

    public Direction opposite() {
        int degrees = this.degrees - 180;
        return ofDegrees(degrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int minuend;
        if ( direction.degrees > 180 && this.degrees == 0 ){
            minuend = 360;
        }else {
            minuend = this.degrees;
        }

        int diference = abs( minuend - direction.degrees);
        return diference;
    }
}
