/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bowling_game_kata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author Godzio
 */
public class BowlingGameTest {

    private final Game game = new Game();

    @Test
    public void testGutterGame() throws Exception {
        int expectedScore = 0;
        hitNPinsInEachOfNRolls( 20, 0 );
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void oneShot_oneKill() throws Exception {
        int expectedScore = 20;
        hitNPinsInEachOfNRolls( 20, 1 );
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void oneSpare_andZeroForRest_expectedScoreIs12() {
        int expectedScore = 14;
        spareRoll();
        game.roll( 2 );
        hitNPinsInEachOfNRolls( 17, 0 );
        assertThat( game.score(), is( expectedScore ) );
    }

    private void spareRoll() {
        game.roll( 5 );
        game.roll( 5 );
    }

    private void hitNPinsInEachOfNRolls( int rolls, int hitsPerRoll ) {
        for ( int i = 0; i < rolls; i++ ) {
            game.roll( hitsPerRoll );
        }
    }
}
