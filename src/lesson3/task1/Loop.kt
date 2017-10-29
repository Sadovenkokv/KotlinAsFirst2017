@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import kotlin.Int.Companion.MAX_VALUE

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var k = 0
    var n = n //делаю переменную n меняемой
    if (n == 0) return 1
    else while (n != 0) {
        n /= 10
        k += 1
    }
    return k
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var beforeLastN=-1  //позапрошлое значение (соответствует fib(n) из условия)
    var previousN=0    //прошлое (соответствует fib(n+1) из условия)
    var n=n //делаю переменную N меняемой
    for (i in 1..n) {
        n = previousN + Math.abs(beforeLastN)
        beforeLastN = previousN
        previousN = n
    }
    return n
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var k = 0
    var m = m
    var n = n
    val m1 = m
    val n1 = n
    while (m != n) {
        if (m > n) m = m - n    //нахожу НОД, сейчас м1 и n1 равны друг другу и имееют значение НОДа
        else n = n - m
    }
    return (m1 * n1 / n)  //формула нахождения НОК: (a*b)/(их НОД)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int):Int {
    var result = 1 //значение переменной неважно
    for (i in 2..n) {
        result = i
        if (n % i == 0) break
    }
    return result
}



/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var max = 0
    for (i in 1..(n-1)) {
        if (n % i == 0) {
            max = Integer.max(max,i)
        }
    }
    return max
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = TODO()
/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var n = n
    var quantityNumber = digitNumber1(n)
    var result = 0
    for (i in 1..digitNumber1(n)) {
        var quantityZero = 1
        val LastNumber = n % 10
        while (quantityNumber != 1) {
            quantityZero *= 10
            quantityNumber -= 1
        }
        n /= 10
        quantityNumber = digitNumber1(n)
        result += (LastNumber * quantityZero)
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = (revert(n) == n)

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var fullString = StringBuilder(MAX_VALUE)
    for (i in 1..n) {
        fullString = StringBuilder(fullString).append(creatSqrNumberN(i))
    }
    return (StringBuilder(fullString)[n]).toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var fullString = StringBuilder(MAX_VALUE)
    for (i in 1..n) {
        fullString = StringBuilder(fullString).append(creatFibNumberN(i))    //По идее, должно работать... Цикл от 1 до ЗАДАННОЙ ЦИФРЫ, в каждом повторе которого будет добавляться переменная от выполненной функции fib; но, опять же, странная ошибка
    }
    return (StringBuilder(fullString)[n]).toInt()
}




/*
Вспомогательные функции
 */


fun digitNumber1(n:Int): Int {
    var k = 0
    var n = n
    if (n == 0) return 1
    while (n != 0) {
        n /= 10
        k += 1
    }
    return k
}

fun creatSqrNumberN(n: Int):Int {
    var result = n
    var quantityNumber = 0
    var count = 0
    var breakCircle = 0
    while (breakCircle == 0) {
        count += 1
        result = count * count
        quantityNumber += digitNumber1(result)
        if (quantityNumber >=n ) breakCircle = 1
    }
    quantityNumber -= n
    for (i in 1..quantityNumber) {
        result /= 10
    }
    return result
}

fun creatFibNumberN(n: Int):Int {
    var beforeLastN=-1
    var previousN=0
    var result = 0
    var quantityNumber = 0
    var breakCircle = 0
    while (breakCircle == 0) {
        result = previousN + Math.abs(beforeLastN)
        quantityNumber += digitNumber1(result)
        beforeLastN = previousN
        previousN = result
        if (quantityNumber >= n) breakCircle = 1
    }
    quantityNumber -= n
    for (i in 1..quantityNumber) {
        result /= 10
    }
    return result
}