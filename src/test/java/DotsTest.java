import calculator.Dots;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DotsTest {
    @Test
    void dots_init_test() {
        String input = "(10,10)-(22,10)-(22,18)-(10,18)";
        Dots dots = new Dots(input);
        assertThat(dots.size()).isEqualTo(4);
    }

    @Test
    void is_line() {
        String input = "(10,10)-(22,10)";
        Dots dots = new Dots(input);
        assertThat(dots.isLine()).isTrue();
    }

    @Test
    void invalid_lineInput_test() {
        String input = "(1,1)1(5,5)";
        String input2 = "(1,1)";
        String input3 = "(25,25)-(25,25)";

        assertThatThrownBy(() -> new Dots(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Dots(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Dots(input3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void is_square() {
        String input = "(10,10)-(22,10)-(22,18)-(10,18)";
        Dots dots = new Dots(input);
        assertThat(dots.isSquare()).isTrue();
    }

    @Test
    void is_not_square() {
        String input = "(10,11)-(22,10)-(22,18)-(10,18)";
        Dots dots = new Dots(input);
        assertThat(dots.isSquare()).isFalse();
    }

    @Test
    void is_triangle() {
        String input = "(10,11)-(22,10)-(22,18)";
        Dots dots = new Dots(input);
        assertThat(dots.isTriangle()).isTrue();
    }

    @Test
    void is_not_triangle() {
        String input = "(10,11)-(22,10)";
        Dots dots = new Dots(input);
        assertThat(dots.isTriangle()).isFalse();
    }

    @Test
    void triangle_area() {
        String input = "(10,11)-(22,10)-(22,18)";
        Dots dots = new Dots(input);

    }
}
