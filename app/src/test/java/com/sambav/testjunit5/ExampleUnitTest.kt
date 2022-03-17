package com.sambav.testjunit5



import org.junit.Assert.*
import org.junit.jupiter.api.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExampleUnitTest {
    var x="100"
    @BeforeAll
    fun testBeforeEach() {
        x="200"
        System.out.println("BeforeEach ${x} ")
    }
    @Test
    @Tag("1st Tag")
    @DisplayName("Hariii")
    fun addition_isCorrect() {
        System.out.println("Helloo ${x} ")
        //assertEquals(4, 2 + 2)
    }
    @Test
    @Tag("1st Tag")
    fun addition_isCorrect1() {
        System.out.println("Helloo1 ${x} ")
        //assertEquals(4, 2 + 2)
    }
    @Test
    fun addition_isCorrect2() {
        System.out.println("Helloo2 ${x} ")
        //assertEquals(4, 2 + 2)
    }
}