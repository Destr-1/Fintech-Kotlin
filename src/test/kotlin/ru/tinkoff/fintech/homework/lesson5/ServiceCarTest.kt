package ru.tinkoff.fintech.homework.lesson5

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ServiceCarTest {
    var listCar = listOf<Car>()
    val car1: Car = Car("Камри", "Тойота", "седан", 2500000, 13.5)
    val car2: Car = Car("Королла", "Тойота", "хэтчбек", 1500000, 8.3)
    val car3: Car = Car("Тиида", "Ниссан", "седан", 1800000, 10.0)
    val car4: Car = Car("Ларгус", "Лада", "универсал", 1000000, 9.8)
    val car5: Car = Car("525", "БМВ", "седан", 4500000, 15.5)

    @BeforeEach
    fun startUp() {
        listCar = listOf<Car>(car1, car2, car3, car4, car5)
    }

    @Test
    fun `тестируем метод translateAndSort для коллекции`() {
        val listCarEng = ServiceCar.translateAndSort(listCar)
        for (i in 1 until listCarEng.size) {
            assertTrue { listCarEng[i - 1].prise <= listCarEng[i].prise }
        }
        for (item in listCarEng) {
            assertTrue { ServiceCar.dictRusToEng.containsValue(item.name) }
            assertTrue { ServiceCar.dictRusToEng.containsValue(item.carBody) }
            assertTrue { ServiceCar.dictRusToEng.containsValue(item.brand) }
        }
    }

    @Test
    fun `тестируем метод translateAndSortSeq, реализованный с помощью последовательности`() {
        val listCarEng = ServiceCar.translateAndSortSeq(listCar)
        for (i in 1 until listCarEng.size) {
            assertTrue { listCarEng[i - 1].prise <= listCarEng[i].prise }
        }
        for (item in listCarEng) {
            assertTrue { ServiceCar.dictRusToEng.containsValue(item.name) }
            assertTrue { ServiceCar.dictRusToEng.containsValue(item.carBody) }
            assertTrue { ServiceCar.dictRusToEng.containsValue(item.brand) }
        }
    }

    @Test
    fun `тестируем метод carGroup для коллекции`() {
        val mpOrigin: Map<String, List<Car>> =
            mapOf("седан" to listOf(car1, car3, car5), "универсал" to listOf(car4), "хэтчбек" to listOf(car2))
        val mp = ServiceCar.carGroup(listCar)
        assertEquals(mp, mpOrigin)
    }

    @Test
    fun `тестируем метод carGroupSeq, реализованный с помощью последовательности`() {
        val mpOrigin: Map<String, List<Car>> =
            mapOf("седан" to listOf(car1, car3, car5), "универсал" to listOf(car4), "хэтчбек" to listOf(car2))
        val mp = ServiceCar.carGroupSeq(listCar)
        assertEquals(mp, mpOrigin)
    }

    @Test
    fun `тестируем метод predik для коллекции`() {
        val listCar = ServiceCar.predik(listCar) { car: Car -> car.petrol100 >= 9 }
        assertEquals(3, listCar.size)
        for (car in listCar)
            assertTrue { car.petrol100 >= 9 }
    }

    @Test
    fun `тестируем метод predikSeq, реализованный с помощью последовательности`() {
        val listCar = ServiceCar.predikSeq(listCar) { car: Car -> car.petrol100 >= 9 }
        assertEquals(3, listCar.size)
        for (car in listCar)
            assertTrue { car.petrol100 >= 9 }
    }
}
