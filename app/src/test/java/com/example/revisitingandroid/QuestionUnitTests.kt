/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid

import com.example.revisitingandroid.main.contents.tdd.QuestionUnitTestHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {

    private lateinit var question : QuestionUnitTestHelper

    @Before
    fun setupTestingQuestionUnitTests()
    {
        question = QuestionUnitTestHelper("CORRECT", "INCORRECT")
    }
    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption()
    {
        Assert.assertNull("The Answered option Should be null", question.answeredOption)
    }

    @Test
    fun whenAnswering_shouldHaveAnsweredOption()
    {
        question.answer(1)
        Assert.assertEquals("The Answered option should not be null", "CORRECT", question.answeredOption)
    }

    @Test
    fun whenAnswering_checkAnsweredOption_shouldReturnTrue_ifOptionCorrect()
    {
        question.answeredOption = "CORRECT"
        val result = question.checkAnsweredOption()

        Assert.assertTrue("The result should be true", result)
    }

    @Test
    fun whenAnswering_checkAnsweredOption_shouldReturnFalse_ifOptionIncorrect()
    {
        question.answeredOption = "INCORRECT"
        val result = question.checkAnsweredOption()

        Assert.assertFalse("The result should be false", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_givenIncorrectOptionNumber_throwIllegalArgumentException()
    {
        question.answer(10)
    }

    @Test
    fun whenAnswering_givenCorrectAnswer_shouldReturnTrue() {
        val result: Boolean = question.answer(1)

        Assert.assertTrue(result)
    }

    @Test
    fun whenAnswering_givenIncorrectAnswer_shouldReturnFalse()
    {
        val result : Boolean = question.answer(2)
        Assert.assertFalse(result)
    }

}