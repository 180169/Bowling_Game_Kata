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

    @Test
    public void testGutterGame() throws Exception {
        Game game = new Game();
        int expectedScore = 0;
        for ( int i = 0; i < 20; i++ ) {
            game.roll( 0 );
        }
        assertThat( game.score(), is( expectedScore ) );
    }

    @Test
    public void oneShot_oneKill() throws Exception {
        Game game = new Game();
        int expectedScore = 20;
        for ( int i = 0; i < 20; i++ ) {
            game.roll( 1 );
        }
        assertThat( game.score(), is( expectedScore ) );
    }
}
