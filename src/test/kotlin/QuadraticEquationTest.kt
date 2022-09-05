import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.Double.NaN
import java.lang.IllegalArgumentException


internal class QuadraticEquationTest {
    lateinit var quadraticEquation: QuadraticEquation

    @BeforeEach
    fun setup() {
        quadraticEquation = QuadraticEquation()
    }

    @Test
    @DisplayName("No roots")
    fun noRoots() {
        assertEquals(listOf<Double>(), quadraticEquation.solve(a = 1.0, b = 0.0, c = 1.0))
    }

    @Test
    @DisplayName("Two roots")
    fun twoRoots() {
        assertEquals(listOf(-1.0, 1.0), quadraticEquation.solve(a = 1.0, b = 0.0, c = -1.0))
    }

    @Test
    @DisplayName("One root")
    fun oneRoot() {
        assertEquals(listOf(-1.0000120000319999), quadraticEquation.solve(a = 1.000008, b = 2.000008, c = 1.0))
    }

    @Test
    @DisplayName("a can't be null")
    fun aCantBeNull() {
        assertThrows(
            IllegalArgumentException::class.java
        ) { quadraticEquation.solve(a = 1.0E-7, b = 2.0, c = 1.0, epsilon = 1.0E-5) }
    }

    @Test
    fun notValidArgumentsNaN() {
        assertThrows(
            IllegalArgumentException::class.java
        ) { quadraticEquation.solve(a = NaN, b = NaN, c = NaN, epsilon = NaN) }
    }

    @Test
    fun notValidArgumentsInfinity() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            quadraticEquation.solve(
                a = Double.POSITIVE_INFINITY,
                b = Double.NEGATIVE_INFINITY,
                c = Double.POSITIVE_INFINITY,
                epsilon = Double.POSITIVE_INFINITY
            )
        }
    }
}