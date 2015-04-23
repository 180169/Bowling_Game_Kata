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
    private static final int MAX_PINS = 10;
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    void roll( int pins ) {
        rolls[currentRoll++] = pins;
    }

    int score() {
        int score = 0;
        int frameIndex = 0;
        for ( int frame = 0; frame < NUMBER_OF_FRAMES; frame++ ) {
            if ( rolls[frameIndex] == MAX_PINS ) {
                score = strikeBonus( score, frameIndex );
                frameIndex++;
            } else if ( checkIfSpare( frameIndex ) ) {
                score = spareBonus( score, frameIndex );
                frameIndex += 2;
            } else {
                score = pinsHitedInFrame( score, frameIndex );
                frameIndex += 2;
            }
        }
        return score;
    }

    private int pinsHitedInFrame( int score, int frameIndex ) {
        score += rolls[frameIndex] + rolls[frameIndex + 1];
        return score;
    }

    private int spareBonus( int score, int frameIndex ) {
        score += MAX_PINS + rolls[frameIndex + 2];
        return score;
    }

    private int strikeBonus( int score, int frameIndex ) {
        score += MAX_PINS + rolls[frameIndex + 1] + rolls[frameIndex + 2];
        return score;
    }

    private boolean checkIfSpare( int frameIndex ) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == MAX_PINS;
    }

}
