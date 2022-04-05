package ru.tinkoff.fintech.homework.lesson6.car

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cars")
class CarsController(private val carService: CarService) {

    @GetMapping("/listCars")
    fun listCars() = carService.listCars()

    @GetMapping("{id}")
    fun getCar(@PathVariable id: Int) = carService.getCar(id)

    @GetMapping("/search")
    fun search(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) brand: String?,
        @RequestParam(required = false) carBody: String?,
        @RequestParam offset: Int,
        @RequestParam limit: Int
    ) =
        carService.search(name, brand, carBody, offset, limit)

    @GetMapping("/translate")
    fun translate() = carService.translate()

    @GetMapping("/priselist")
    fun getPriseList() = carService.getPriseList()

    @PostMapping("/addCar")
    fun carAdd(
        @RequestParam name: String,
        @RequestParam brand: String,
        @RequestParam carBody: String,
        @RequestParam petrol100: Double,
        @RequestParam prise: Int
    ) =
        carService.carAdd(name, brand, carBody, petrol100, prise)
}



