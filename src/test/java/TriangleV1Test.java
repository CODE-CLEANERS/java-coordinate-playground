import calculator.Dots;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;

class TriangleV1Test {
    @Test
    void is_triangle() {
        String input = "(10,11)-(22,10)-(22,18)";
        Dots dots = new Dots(input);
        assertThat(dots.isTriangle()).isTrue();
    }

    @Test
    void get_triangle_distances() {
        String input = "(10,11)-(22,10)-(22,18)";
        Dots dots = new Dots(input);
        assertThat(dots.getLinesLength()).isEqualTo(33.93, offset(0.01));
    }

    @Test
    void get_triangle_area() {
        String input = "(10,11)-(22,10)-(22,18)";
        Dots dots = new Dots(input);
        assertThat(dots.getTriangleArea()).isEqualTo(48, offset(0.1));
    }
}
