fun main(args: Array<String>) {
    val (a, b, c, epsilon) = args.map { it.toDouble() }
    val quadraticEquation = QuadraticEquation()
    quadraticEquation.solve(a, b, c, epsilon)
}