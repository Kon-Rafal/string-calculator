package com.company;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTests {

  private Calculator calculator;

  @Before
  public void before() {
    calculator = new Calculator();
  }

  @Test
  public void shouldReturnZeroForEmptyString() {
    assertEquals(0, calculator.add(""));
  }

  @Test
  public void shouldReturnTheSameNumberForOneNumberInString() {
    assertEquals(1, calculator.add("1"));
    assertEquals(2, calculator.add("2"));
  }

  @Test
  public void shouldReturnCalculateResultForTwoNumbersInString() {
    assertEquals(3, calculator.add("1,2"));
  }
}