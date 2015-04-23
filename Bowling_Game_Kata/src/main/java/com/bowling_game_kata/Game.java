/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bowling_game_kata;

/**
 *
 * @author Godzio
 */
class Game {

    private static final int NUMBER_OF_FRAMES = 10;
    private static final int SPARE_SCORE = 10;
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    void roll( int pins ) {
        rolls[currentRoll++] = pins;
    }

    int score() {
        int score = 0;
        int frameIndex = 0;
        for ( int frame = 0; frame < NUMBER_OF_FRAMES; frame++ ) {
            if ( checkIfSpare( frameIndex ) ) {
                score += SPARE_SCORE + rolls[frameIndex + 2];
                frameIndex += 2;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean checkIfSpare( int frameIndex ) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == SPARE_SCORE;
    }

}
