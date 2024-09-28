package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
	testDemo = new TestDemo();	
		
	}

	//@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive") 
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, Object expected, boolean expectException) {
		//Given: two integers to add together
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		//When: the method to add two positive numbers is called
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
			expected = null;
		//Then: If the numbers are positive they will be added together. If not, the value will be null and an exception is thrown.
		}
	}
	
	static Stream <Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
		
		arguments(2, 5, 7, false),
		arguments(0, 8, null, true),
		arguments(-2, 2, null, true),
		arguments(-2, -2, null, true));
		//@formatter:on
				
	}
	//@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(8,7)).isEqualTo(15);
		assertThat(testDemo.addPositive(3,3)).isEqualTo(6);
		assertThat(testDemo.addPositive(10,10)).isEqualTo(20);
		assertThat(testDemo.addPositive(40,30)).isEqualTo(70);
		
	}
	
	//@Test
	void assertThatEvenNumbersAreMultipliedTogetherCorrectly() {
		assertThat (testDemo.checkToSeeIfNumbersAreEvenThenMultiplyThemTogether(10,2)).isEqualTo(20);
		assertThat (testDemo.checkToSeeIfNumbersAreEvenThenMultiplyThemTogether(4,12)).isEqualTo(48);
		assertThat (testDemo.checkToSeeIfNumbersAreEvenThenMultiplyThemTogether(6,0)).isEqualTo(0);
		assertThat (testDemo.checkToSeeIfNumbersAreEvenThenMultiplyThemTogether(-8,4)).isEqualTo(-32);
	
	}
	
	//@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForCheckToSeeIfNumbersAreEvenThenMultiplyThemTogether") 
	void assertOddNumbersThrowException(int c, int d, Object expected, boolean expectException) {
		//Given: two integers to multiply together
		if (!expectException) {
			assertThat(testDemo.checkToSeeIfNumbersAreEvenThenMultiplyThemTogether(c, d)).isEqualTo(expected);
		//When: the method to multiply two even numbers together is called
		} else {
			assertEquals(expected, IllegalArgumentException.class); 
			expected = IllegalArgumentException.class;
		//Then: If both numbers are even they are multiplied together. If not, an exception is thrown.
		}	
			}
			
	static Stream <Arguments> argumentsForCheckToSeeIfNumbersAreEvenThenMultiplyThemTogether() {
				//@formatter:off
				return Stream.of(
				
				arguments(2, 5, IllegalArgumentException.class, true),
				arguments(-6, 2, -12, false),
				arguments(6, 4, 24, false),
				arguments(1, 8, IllegalArgumentException.class, true),
				arguments(-2, 5, IllegalArgumentException.class, true),
				arguments(4, -11, IllegalArgumentException.class, true));
				//@formatter:on
						
			}
	
	//This method tests to see if a a number is squared correctly. 
	//Since a random number is generated, this mock TestDemo uses the number 5 to make sure the test works correctly. 
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	}

