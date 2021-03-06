data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

    val abs = Math.hypot(real, imag)

    operator fun plus(other: ComplexNumber)
            = copy(real = real + other.real, imag = imag + other.imag)

    operator fun minus(other: ComplexNumber)
            = copy(real = real - other.real, imag = imag - other.imag)

    operator fun times(other: ComplexNumber)
            = copy(real = real*other.real - imag*other.imag, imag = real*other.imag + imag*other.real)

    operator fun div(other: ComplexNumber)
            = this * other.conjugate() / Math.pow(other.abs, 2.0)

    operator fun times(factor: Double)
            = copy(real = factor * real, imag = factor * imag)

    operator fun div(factor: Double)
            = copy(real = real / factor, imag = imag / factor)

    fun conjugate() = copy(imag = -1 * imag)

}

fun exponential(exponent: ComplexNumber)
        = ComplexNumber(real = Math.cos(exponent.imag), imag = Math.sin(exponent.imag)) * Math.exp(exponent.real)
