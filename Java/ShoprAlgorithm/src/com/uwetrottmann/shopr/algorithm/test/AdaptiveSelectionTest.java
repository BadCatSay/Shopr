
package com.uwetrottmann.shopr.algorithm.test;

import static org.fest.assertions.api.Assertions.assertThat;

import com.uwetrottmann.shopr.algorithm.model.Color;

import org.junit.Test;

public class AdaptiveSelectionTest {

    @Test
    public void testLikeValue() {
        // all equal
        double[] actual = new double[] {
                0.25, 0.25, 0.25, 0.25
        };
        double[] expected = new double[] {
                0.25 - 0.25 / 3, 0.5, 0.25 - 0.25 / 3, 0.25 - 0.25 / 3
        };
        new Color().likeValue(1, actual);
        assertThat(actual).isEqualTo(expected);

        // one getting bigger than zero
        actual = new double[] {
                0.4 / 3, 0.6, 0.4 / 3, 0.4 / 3
        };
        expected = new double[] {
                0.05, 0.85, 0.05, 0.05
        };
        new Color().likeValue(1, actual);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testdislikeValue() {
        // all equal
        double[] actual = new double[] {
                0.25, 0.25, 0.25, 0.25
        };
        double[] expected = new double[] {
                0.25 + 0.25 / 3, 0.0, 0.25 + 0.25 / 3, 0.25 + 0.25 / 3
        };
        new Color().dislikeValue(1, actual);
        assertThat(actual).isEqualTo(expected);

        // two zero, keep them zero
        actual = new double[] {
                0.0, 0.5, 0.0, 0.5
        };
        expected = new double[] {
                0.0, 0.0, 0.0, 1.0
        };
        new Color().dislikeValue(1, actual);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testLikeDislikeValue() {
        // first dislike
        double[] actual = new double[] {
                0.25, 0.25, 0.25, 0.25
        };
        double[] expected = new double[] {
                0.25 + 0.25 / 3, 0.0, 0.25 + 0.25 / 3, 0.25 + 0.25 / 3
        };
        new Color().dislikeValue(1, actual);
        assertThat(actual).isEqualTo(expected);

        // then like again
        expected = new double[] {
                0.25, 0.25, 0.25, 0.25
        };
        new Color().likeValue(1, actual);
        assertThat(actual).isEqualTo(expected);
    }

}
