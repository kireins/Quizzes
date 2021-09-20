import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kirei.quizzes.Quiz
import com.kirei.quizzes.R
import com.kirei.quizzes.databinding.FragmentQuizBinding
import com.kirei.quizzes.getListQuiz

class QuizFragment : Fragment() {
    private val questions = getListQuiz()
    private var questionIndex = 0
    private val numberIndicatorQuestion = Math.min((questions.size + 1) / 2, 5)
    lateinit var currentQuestion: Quiz
    lateinit var answers: MutableList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quizBinding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater,
            R.layout.fragment_quiz,
            container,
            false
        )

        randomQuestion()
        quizBinding.quiz = this
        quizBinding.btnSubmit.setOnClickListener { view: View ->
            val checkedId = quizBinding.rgQuiz.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerCorrectPosition = 0
                when (checkedId) {
                    R.id.rb_option_2 -> answerCorrectPosition = 1
                    R.id.rb_option_3 -> answerCorrectPosition = 2
                    R.id.rb_option_4 -> answerCorrectPosition = 3
                }
                if (answers[answerCorrectPosition] == currentQuestion.answers[0]) {
                    questionIndex++
                    updateStep(questions[questionIndex])
                    if (questionIndex < numberIndicatorQuestion) {
                        currentQuestion = questions[questionIndex]
                        setNumberQuestion()
                        quizBinding.invalidateAll()
                    } else {
                        view.findNavController().navigate(R.id.action_quizFragment_to_wonFragment)
                    }
                } else {
                    view.findNavController().navigate(R.id.action_quizFragment_to_overFragment)
                }
            }
        }

        return quizBinding.root
    }

    private fun updateStep(current: Quiz) {
        val sizes = ArrayList<Quiz>()
        questions.forEach { question ->
            question.isCurrent = (question == current)
            sizes.add(question)
        }
        questions.clear()
        questions.addAll(sizes)
    }


    private fun randomQuestion() {
        questions.shuffle()
        questionIndex = 0
        questions[questionIndex].isCurrent = true
        setNumberQuestion()
    }

    private fun setNumberQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()

        (activity as AppCompatActivity).supportActionBar?.title = getString(
            R.string.title_quizzes,
            questionIndex + 1,
            numberIndicatorQuestion
        )
    }

}