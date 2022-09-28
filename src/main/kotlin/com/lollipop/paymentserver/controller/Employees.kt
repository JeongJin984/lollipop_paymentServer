package com.lollipop.paymentserver.controller

import java.time.LocalDate

class Employees (
    val empNo : Int,
    val birthDate: LocalDate,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val hireDate: LocalDate,
)