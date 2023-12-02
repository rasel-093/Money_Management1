package com.example.money_management1.model

enum class IncomeCategory(val label: String) {
    SALARY("Salary"),
    BUSINESS_INCOME("Business Income"),
    INVESTMENT_INCOME("Investment Income"),
    GIFTS_RECEIVED("Gifts Received"),
    OTHER_INCOME("Other Income"),
}
enum class ExpenseCategory(val label: String){
    RENT("Rent"),
    UTILITIES("Utilities"),
    GROCERIES("Groceries"),
    TRANSPORTATION("Transportation"),
    DEBT_PAYMENT("Debt Payment"),
    ENTERTAINMENT("Entertainment"),
    SHOPPING("Shopping"),
    TRAVEL("Travel"),
    DONATIONS("Donations"),
    FOOD("Food"),
    SAVINGS("Savings"),
    EDUCATIONAL_EXPENSE("Educational expense"),
    OTHERS("Others")
}

enum class Month(val month: String){
    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December")
}