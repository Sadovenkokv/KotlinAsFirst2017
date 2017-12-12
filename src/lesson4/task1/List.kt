@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.digitNumber1
import lesson3.task1.minDivisor
import lesson3.task1.revert
import java.lang.Math.*

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var abs = 0.0
    for (element in v) {
        abs += sqr(element)
    }
    return sqrt(abs)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var result = 0.0
    for (element in list) {
        result += element/list.size
    }
    return result
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()
/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for (i in 0 until max(a.size,b.size)) {
        c += a[i]*b[i]
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var result = 0.0
    for (i in 0 until p.size) {
        result += p[i]*pow(x,i.toDouble())
    }
    return result
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    for (i in 1 until list.size) {
        list[i] = list[i - 1] + list[i]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var mutList = mutableListOf<Int>()
    var n = n
    while (n != 1) {
        mutList.add(minDivisor(n))
        n /= minDivisor(n)
    }
    return mutList
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var list = factorize(n)
    list.sorted()
    return (list.joinToString(separator = "*"))
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var n = n
    var list = mutableListOf<Int>()
    while (n >= base) {
        list.add(n%base)
        n /= base
    }
    list.add(n)
    val size = list.size-1
    for (i in 0..size/2) {
        val buffer = list[i]
        list[i] = list[size-i]
        list[size-i] = buffer
    }
    return list
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var letterUnicode = 87
    var result = ""
    var list = convert(n,base)
    for (i in 0 until list.size) {
        result += if (list[i] > 9) {
            (list[i] + letterUnicode).toChar()
        }
        else list[i]
    }
    return result
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var quantityNumber = digitNumber1(n)
    return strToRussian(quantityNumber,n)
}

fun strToRussian(quantityNumber: Int, n: Int): String {
    var string = StringBuilder()   //в неё складывается результаты
    var quantityNumber = quantityNumber //количетсво цифр в числе, которые помогают определить разрядность числа
    var n = n //просто превращаю val в var
    var n1 = n % 1000 //позже понадобится
    n /= 1000
    if (quantityNumber == 6) { //900 000
        string.append(fromNumbersToWords( n / 100, 3))
        n %= 100
        quantityNumber = 5
    }
    if (quantityNumber == 5) {
        if ((n >= 11) && (n <= 19)) {
            string.append(specialNumbers(n) + "тысяч ")
            quantityNumber = 3
        }
        else {
            string.append(fromNumbersToWords(n / 10, 2))
            n %= 10
            quantityNumber = 4
        }
    }
    if (quantityNumber == 4) {
        if (n == 1) string.append("одна тысяча ")
        if (n == 2) string.append("две тысячи ")
        if ((n >= 3) || (n == 0)) string.append(fromNumbersToWords(n, 4))
        quantityNumber = 3
    }
    if (quantityNumber <= 3) {
        if ((n1 % 100 >= 11) && (n1 % 100 <= 19)) {
            string.append(fromNumbersToWords(n1 / 100, 3))
            string.append(specialNumbers(n1 % 100))
        }
        else
            for (i in 3 downTo 1) {
                val neededNumber = n1 / pow(10.0, (i - 1).toDouble()).toInt()
                string.append(fromNumbersToWords(neededNumber, i))
                n1 %= pow(10.0, (i - 1).toDouble()).toInt()
            }
    }
    return Regex("""\s$""").replace(string.toString(),"")
}

fun fromNumbersToWords(n: Int,quantityNumber: Int): String { //задача данной функции переделывать цифры в их разрядности
    var result = StringBuilder()
    if (quantityNumber == 1) { //единицы
        result.append(from1to9InWords(n))
    }
    if (quantityNumber == 2) { //десятки
        if (n == 1) result.append("десять ")
        if ((n >= 2) && (n <= 3)) result.append(from1to9InWords(n) + "дцать ")
        if (n == 4) result.append("сорок ")
        if ((n >= 5) && n <=8)  result.append(from1to9InWords(n) + "десят ")
        if (n == 9) result.append("девяносто ")
    }
    if (quantityNumber == 3) { //сотни
        if (n == 1) result.append("сто ")
        if (n == 2) result.append("двести ")
        if ((n >= 3) && (n <= 4)) result.append(from1to9InWords(n) + "ста ")
        if (n >= 5) result.append(from1to9InWords(n) + "сот ")
    }
    if (quantityNumber == 4) { //тысячи
        if (n == 0) result.append("тысяч ")
        if (n == 1) result.append(from1to9InWords(n) + " тысяча ")
        if ((n >= 2) && (n <= 4)) result.append(from1to9InWords(n) + " тысячи ")
        if (n >= 5) result.append(from1to9InWords(n) +  " тысяч ")
    }
    return result.toString()
}

fun from1to9InWords(n: Int): String = when (n) {
    0 -> ""
    1 -> "один"
    2 -> "два"
    3 -> "три"
    4 -> "четыре"
    5 -> "пять"
    6 -> "шесть"
    7 -> "семь"
    8 -> "восемь"
    else -> "девять"
}

fun specialNumbers(n: Int):String = when (n) {
    11 -> "одиннадцать "
    12 -> "двенадцать "
    13 -> "тринадцать "
    14 -> "четырнадцать "
    15 -> "пятнадцать "
    16 -> "шестнадцать "
    17 -> "семнадцать "
    18 -> "восемнадцать "
    else -> "девятнадцать "
}