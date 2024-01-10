package com.example.money_management1.tips

import com.example.money_management1.model.trxmodel.TrxItem
import java.util.Calendar

//fun generateTips(transactions: List<TrxItem>): List<String> {
//    // Implement your logic to analyze transactions and generate tips
//    // This is a simplified example, you can customize it based on your requirements
//    val totalIncome = transactions.filter { it.type }.sumBy { it.amount }
//    val totalExpense = transactions.filter { !it.type }.sumBy { it.amount }
//
//    val tips = mutableListOf<String>()
//
//    if (totalIncome > totalExpense) {
//        tips.add("Great job! Your income exceeds your expenses.")
//    } else if (totalExpense > totalIncome) {
//        tips.add("Consider reviewing your expenses to save more.")
//    } else {
//        tips.add("Maintaining a balance between income and expenses.")
//    }
//
//    // Add more tips based on your analysis
//
//    return tips
//}
// Updated generateTips function
fun generateTips(transactions: List<TrxItem>): List<String> {
    val currentDate = Calendar.getInstance()
    val currentMonth = currentDate.get(Calendar.MONTH) + 1
    val currentYear = currentDate.get(Calendar.YEAR)

    // Filter transactions for the current month and year
//    val currentMonthTransactions = transactions.filter {
//        val transactionDate = Calendar.getInstance()
//        transactionDate.timeInMillis = it.date
//        val transactionMonth = transactionDate.get(Calendar.MONTH) + 1
//        val transactionYear = transactionDate.get(Calendar.YEAR)
//
//        transactionMonth == currentMonth && transactionYear == currentYear
//    }

    val totalIncome = transactions.filter { it.type }.sumBy { it.amount }
    val totalExpense = transactions.filter { !it.type }.sumBy { it.amount }

    val tips = mutableListOf<String>()

    // Analyze monthly income and expenses
    if (totalIncome > totalExpense) {
        tips.add("Great job! Your income exceeds your expenses.")
    } else if (totalExpense > totalIncome) {
        tips.add("Consider reviewing your expenses to save more.")
    } else {
        tips.add("Maintaining a balance between income and expenses.")
    }

    // Advise on monthly expenses
    val suggestedExpenseLimit = totalIncome * 0.7 // Adjust as needed
    if (totalExpense > suggestedExpenseLimit) {
        tips.add("You have exceeded the recommended monthly expense limit. Review your spending.")
    } else {
        tips.add("You are within the recommended monthly expense limit.")
    }

    // Provide a spending limit suggestion
    val remainingBudget = totalIncome - totalExpense
    val spendingLimit = totalExpense + remainingBudget * 0.3 // Adjust as needed
    tips.add("Your suggested spending limit for the month is $$spendingLimit.")

    // Encourage users to save money
    val savingsGoal = totalIncome * 0.2 // Adjust as needed
    if (remainingBudget > savingsGoal) {
        tips.add("You're doing great! You have surplus funds. Consider saving more.")
    } else {
        tips.add("Consider saving at least ${savingsGoal - remainingBudget} more to reach your savings goal.")
    }

    // Add more tips based on your analysis

    return tips
}
