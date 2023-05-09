/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid

import com.example.revisitingandroid.main.contents.tdd.GameTestHelper
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameUnitTest {

    private lateinit var gameTestHelper : GameTestHelper

    @Before
    fun prepareTDDShitBro()
    {
        gameTestHelper = GameTestHelper()
    }
    @After
    fun clearTDDSHitBro()
    {
        gameTestHelper = GameTestHelper()
    }
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore()
    {
        gameTestHelper.incrementScore()

        Assert.assertEquals("Current score should have been 1 ", 1, gameTestHelper.currentScore)
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore()
    {
        gameTestHelper.incrementScore()

        Assert.assertEquals("Current High score should be increment by 1", 1 , gameTestHelper.highScore)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore()
    {
        gameTestHelper.highScore = 2

        gameTestHelper.incrementScore()

        Assert.assertEquals("High Score should not increment while currentScore below the HighScore", 2, gameTestHelper.highScore)
    }


    @Test
    fun whenNextQuestioning_currentIndexQuestion_shouldIncrement()
    {
        gameTestHelper.nextQuestion()
        Assert.assertEquals("currentIndexQuestion should increment by 1", 1, gameTestHelper.currentIndexQuestion)
    }

    @Test
    fun whenNextQuestioning_currentIndexQuestion_shouldNotExceed_listOfQuestionsSize()
    {
        gameTestHelper.currentIndexQuestion = 2
        gameTestHelper.nextQuestion()
        Assert.assertEquals("currentIndexQuestion Max should be ${gameTestHelper.listOfQuestions.size - 1}", gameTestHelper.listOfQuestions.size-1, gameTestHelper.currentIndexQuestion)
    }

    @Test
    fun whenNextQuestioning_currentIndexQuestion_haveSameSize_with_listOfQuestionsSize_returnLastQuestion()
    {
        gameTestHelper.currentIndexQuestion = 1
        val question = gameTestHelper.nextQuestion()
        Assert.assertEquals("Question should be last item from listOfQuestions", gameTestHelper.listOfQuestions[gameTestHelper.listOfQuestions.size - 1], question)

    }
}