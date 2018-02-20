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
public class FizzBuzz1Test {
    private static final int TEST_NUMBER = 1;
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    @Mock NumberTester divisibleBy3Tester;
    private Fizzbuzz1 fizzbuzz;

    @Before
    public void setUp() {
        fizzbuzz = new Fizzbuzz1(divisibleBy3Tester);
    }

    @Test
    public void given_number_divisible_by_3_returns_fizz() {
        // given
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void given_number_not_divisible_by_3_returns_number_to_string() {
        // given
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(Integer.toString(TEST_NUMBER));
    }
}
