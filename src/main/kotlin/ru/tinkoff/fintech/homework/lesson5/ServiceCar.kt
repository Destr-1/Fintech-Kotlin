package ru.tinkoff.fintech.homework.lesson5

class ServiceCar {
    companion object {
        const val exchangeRate = 0.01
        val dictRusToEng = mapOf(
            "Тойота" to "Toyota",
            "Ниссан" to "Nissan",
            "БМВ" to "BMW",
            "Лада" to "LADA",
            "седан" to "sedan",
            "хэтчбек" to "hatchback",
            "универсал" to "universal",
            "Камри" to "Camry",
            "Королла" to "Corolla",
            "Ларгус" to "Largus",
            "Тиида" to "Tiida",
            "525" to "525"
        )

        fun translateAndSort(list: Collection<Car>): List<Car> =
            list.map { changeCarRusToEng(it) }.sortedBy { it.prise }

        private fun changeCarRusToEng(car: Car): Car {
            val newPrise: Int = (car.prise * exchangeRate).toInt()
            val newName = dictRusToEng.getOrDefault(car.name, car.name)
            val newBrand = dictRusToEng.getOrDefault(car.brand, car.brand)
            val newCarBody = dictRusToEng.getOrDefault(car.carBody, car.carBody)
            return Car(newName, newBrand, newCarBody, newPrise, car.petrol100)
        }

        fun carGroup(list: Collection<Car>): Map<String, List<Car>> = list.groupBy { it.carBody }

        fun predik(cars: List<Car>, f: (car: Car) -> Boolean) = translateAndSort(cars.filter(f)).take(3)

        fun translateAndSortSeq(list: Collection<Car>): List<Car> =
            list.asSequence().map { changeCarRusToEng(it) }.sortedBy { it.prise }.toList()

        fun carGroupSeq(list: Collection<Car>): Map<String, List<Car>> =
            list.asSequence().groupBy { it.carBody }.toMap()

        fun predikSeq(cars: List<Car>, f: (car: Car) -> Boolean) = translateAndSortSeq(cars.filter(f)).take(3)
    }
}
