import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class QuadraticEquation {

    fun solve(a: Double, b: Double, c: Double, epsilon: Double =  1.0E-5): List<Double> {

        when {
            a.isNaN() || b.isNaN() || c.isNaN() || epsilon.isNaN() -> throw IllegalArgumentException("argument is NaN")
            a.isInfinite() || b.isInfinite() || c.isInfinite() || epsilon.isInfinite() -> throw IllegalArgumentException("argument is Infinite")
            abs(a) < epsilon -> throw IllegalArgumentException("a is less than epsilon")
            else -> Unit
        }
        val discriminant: Double = b.pow(2) - 4 * a * c
        return when {
            discriminant > epsilon -> {
                val x1 = (-b + sqrt(discriminant)) / 2 * a
                val x2 = (-b - sqrt(discriminant)) / 2 * a
                listOf(x1, x2).sorted()

            }
            abs(discriminant) < epsilon -> listOf(-b / 2 * a)
            discriminant < epsilon -> emptyList()
            else -> throw Exception("wrong discriminant: $discriminant")
        }
    }
}