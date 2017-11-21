@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Integer.max

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String = when {
    ((age % 100 in 11..20)) -> "$age лет"
    (age % 10 == 1) -> "$age год"
    ((age % 10 in 2..4)) -> "$age года"
    else -> "$age лет"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    /** sA - весь путь (sAll)*/
    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    val sA = s1 + s2 + s3
    return when {
        sA / 2 < s1 -> (sA / 2) / v1
        sA / 2 < (s1 + s2) -> ((sA / 2 - s1) / v2) + t1
        else -> ((sA / 2 - s2 - s1) / v3) + t2 + t1
    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    val YDeductY1 = kingY - rookY1  //deduct - вычесть
    val XDeductX1 = kingX - rookX1
    val YDeductY2 = kingY - rookY2
    val XDeductX2 = kingX - rookX2
    var result = 0
    when {
        ((YDeductY1 != 0) && (XDeductX1 == 0)) -> result += 1
        ((XDeductX1 != 0) && (YDeductY1 == 0)) -> result += 1
        else -> result
    }
    when {
        ((YDeductY2 != 0) && (XDeductX2 == 0)) -> result += 3
        ((XDeductX2 != 0) && (YDeductY2 == 0)) -> result += 3
        else -> result
    }
    return when (result) {
        0, 1 -> result
        else -> result - 1
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    val kXDeductRX = kingX - rookX
    val kYDeductRY = kingY - rookY
    val kXDeductBX = kingX - bishopX
    val kYDeductBY = kingY - bishopY
    val kXSumKY = kingX + kingY
    val bXSumBY = bishopX + bishopY
    var result = 0
    if (((kYDeductRY != 0) && (kXDeductRX == 0)) || ((kXDeductRX != 0) && (kYDeductRY == 0))) result += 1
    if ((kXDeductBX == kYDeductBY) || (kXSumKY == bXSumBY)) result += 3
    return when (result) {
        0, 1 -> result
        else -> result - 1
    }
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    var max = maxOf(a, c)
    max = maxOf(b, max)
    val sqrASumB = sqr(a) + sqr(b)
    val sqrBSumC = sqr(b) + sqr(c)
    val sqrCSumA = sqr(c) + sqr(a)
    return when {
        (((sqrASumB > sqr(c)) && max == c) ||
                ((sqrBSumC > sqr(a)) && max == a) ||
                ((sqrCSumA > sqr(b)) && max == b)) -> 0
        ((sqr(c) == sqrASumB) ||
                (sqr(a) == sqrBSumC) ||
                (sqr(b) == sqrCSumA)) -> 1
        ((c > a + b) || (a > b + c) || (b > c + a)) -> -1
        else -> 2
    }
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (a >= c) {
        return when {
            (a > d) -> -1
            (b > d) -> (d - a)
            else -> (b - a)
        }
    } else {
        return when {
            (c > b) -> -1
            (b > d) -> (d - c)
            else -> (b - c)
        }
    }
}
