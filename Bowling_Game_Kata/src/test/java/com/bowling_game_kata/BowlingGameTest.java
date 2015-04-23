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
        for ( int i = 0; i < 20; i++ ) {
            game.roll( 0 );
        }
        assertThat( game.score(), is( 0 ) );
    }
}
