package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int x, int y, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(x, y)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(x, y)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
				arguments(2, 7, 9, false),
				arguments(-12, 7, -5, true),
				arguments(2, -7, -5, true),
				arguments(0, 7, 7, true),
				arguments(2, 0, 2, true)
				);
		// @formatter:on
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(6, 9)).isEqualTo(15);
		assertThat(testDemo.addPositive(7, 5)).isEqualTo(12);
		assertThat(testDemo.addPositive(5, 7)).isEqualTo(12);
	}
	
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForConcatWords")
	void assertThatTwoWordsAreConcatenatedProperly(String w1, String w2, String expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.concatWords(w1, w2)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.concatWords(w1, w2)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForConcatWords() {
		// @formatter:off
			return Stream.of(
					arguments("Single", "Word", "SingleWord", false),
					arguments("Multi", "Word s", "MultiWord s", true),
					arguments("Multi ", "Words", "Multi Words", true),
					arguments("Multi ", "Word s", "Multi Word s", true)
					);
		// @formatter:on
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}
