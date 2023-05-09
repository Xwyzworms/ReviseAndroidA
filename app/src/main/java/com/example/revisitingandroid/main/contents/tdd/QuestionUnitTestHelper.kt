/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.tdd

import java.lang.IllegalArgumentException

class QuestionUnitTestHelper(correctOption : String, incorrectOption : String) {

    var correctOption = correctOption
        private set

    var incorrectOption = incorrectOption
        private set
    private val isAnsweredCorrectly : Boolean
        get() = correctOption == answeredOption

    var answeredOption  : String? = null
    fun answer(option : Int) :Boolean
    {
        setAnsweredOption(option)
        return checkAnsweredOption()
    }

    private fun setAnsweredOption(option : Int)
    {
        answeredOption = when(option) {
            1 -> {
                correctOption
            }

            2-> {
                incorrectOption
            }

            else -> {
                throw IllegalArgumentException("Not a valid Option")
            }
        }
    }

    fun checkAnsweredOption () : Boolean
    {
        return isAnsweredCorrectly
    }


}