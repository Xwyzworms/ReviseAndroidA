/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.tdd

class GameTestHelper {
    var currentScore : Int = 0
        private set

    var highScore : Int = 0
    var currentIndexQuestion = 0
    val listOfQuestions : List<QuestionUnitTestHelper> = arrayListOf(
        QuestionUnitTestHelper("Bro", "Sure"),
        QuestionUnitTestHelper("Dear", "Live"),
        QuestionUnitTestHelper("Some", "Shit"),
    )
    fun nextQuestion() : QuestionUnitTestHelper
    {
        val nextQuestion : QuestionUnitTestHelper = listOfQuestions[currentIndexQuestion]
        if(currentIndexQuestion < listOfQuestions.size -1 )
        {
            currentIndexQuestion++
        }

        return nextQuestion
    }
    fun incrementScore()
    {
        currentScore ++
        if(highScore < currentScore)
        {
            highScore = currentScore;
        }
    }


}