import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzz3Test {
    private static final int TEST_NUMBER = 1;
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";
    private static final String FOOBAR = "Foobar!";

    @Mock NumberTester divisibleBy3Tester;
    @Mock NumberTester divisibleBy5Tester;
    @Mock NumberTester is15Tester;
    private Fizzbuzz3 fizzbuzz3;

    @Before
    public void setUp() {
        fizzbuzz3 = new Fizzbuzz3(divisibleBy3Tester, divisibleBy5Tester, is15Tester);
    }

    @Test
    public void given_not_15_and_number_divisible_by_3_and_not_divisible_by_5_returns_fizz() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void given_not_15_and_number_not_divisible_by_3_and_divisible_by_5_returns_buzz() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void given_not_15_and_number_divisible_by_3_and_divisible_by_5_returns_fizzbuzz() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FIZZBUZZ);
    }

    @Test
    public void given_not_15_and_number_not_divisible_by_3_and_not_divisible_by_5_returns_number_to_string() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(Integer.toString(TEST_NUMBER));
    }

    @Test
    public void given_15_and_number_divisible_by_3_and_not_divisible_by_5_returns_foobar() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FOOBAR);
    }

    @Test
    public void given_15_and_number_not_divisible_by_3_and_divisible_by_5_returns_foobar() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FOOBAR);
    }

    @Test
    public void given_15_and_number_divisible_by_3_and_divisible_by_5_returns_foobar() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(true);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FOOBAR);
    }

    @Test
    public void given_15_and_number_not_divisible_by_3_and_not_divisible_by_5_returns_foobar() {
        // given
        given(is15Tester.satisfiesCondition(anyInt())).willReturn(true);
        given(divisibleBy3Tester.satisfiesCondition(anyInt())).willReturn(false);
        given(divisibleBy5Tester.satisfiesCondition(anyInt())).willReturn(false);

        // when
        String result = fizzbuzz3.toString(TEST_NUMBER);

        // then
        assertThat(result).isEqualTo(FOOBAR);
    }
}
