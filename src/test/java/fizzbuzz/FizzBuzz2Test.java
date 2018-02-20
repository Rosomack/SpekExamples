package fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzz2Test {
    private static final int TEST_NUMBER = 1;
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    @Mock NumberTester divisibleBy3Tester;
    @Mock NumberTester divisibleBy5Tester;
    private Fizzbuzz2 fizzbuzz2;

    @Before
    public void setUp() {
        fizzbuzz2 = new Fizzbuzz2(divisibleBy3Tester, divisibleBy5Tester);
    }

    @Test
    public void given_number_divisible_by_3_and_not_divisible_by_5_returns_fizz() {
        // given
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz2.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void given_number_not_divisible_by_3_and_divisible_by_5_returns_buzz() {
        // given
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz2.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void given_number_divisible_by_3_and_divisible_by_5_returns_fizzbuzz() {
        // given
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz2.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FIZZBUZZ);
    }

    @Test
    public void given_number_not_divisible_by_3_and_not_divisible_by_5_returns_number_to_string() {
        // given
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz2.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(Integer.toString(TEST_NUMBER));
    }
}
