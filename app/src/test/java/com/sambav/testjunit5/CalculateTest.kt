package com.sambav.testjunit5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.opentest4j.AssertionFailedError
import java.lang.Exception

internal class CalculateTest{
    @Test
    @DisplayName("Expected ad Actual values are same")
    fun testAdd(){
        var c = Calculate()
        Assertions.assertEquals(3,c.add(1,2),"Eqal")
    }
    @RepeatedTest(10)
    fun repeatedTest() {
       System.out.println("A - value ")
    }
    @Test
    fun testAssertAll(){
        var c = Calculate()
        Assertions.assertAll(
            Executable { Assertions.assertEquals(3, c.add(1, 2), "Eqal") },
            Executable { Assertions.assertEquals(5, c.add(2, 2), "values is not equal 5") }
        )
    }

    @Test
    fun testAssertTrue(){
        Assertions.assertEquals(3, 4) {
            "Three does not equal four"
        }
    }
    @Test
    fun testAssertTrueEx(){
        try {
            Assertions.assertEquals(4, 4)
            System.out.print("Both are same...")
        }catch (e: AssertionFailedError){
            fail("-------------------------\n"+e.message+"\n-------------------------\n")
        }
    }

    @ParameterizedTest
    @ValueSource(strings= arrayOf("Test1","aaaa"))
    fun checkParameterized(name:String){
        val envs = listOf("development", "Test1", "production")
        try {
            //assertTrue(name.contains("Test"))
            assertTrue(envs.contains(name))
        }catch (e:AssertionFailedError){
            fail("Given String is not contain Test")
        }
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(ints = [1, 2, 3])
    fun test_int_arrays_custom_name(arg: Int) {
        try {
            assertTrue(arg > 1)
        }catch (e:AssertionFailedError){
            fail("${arg} is less than 1")
        }

    }
}

