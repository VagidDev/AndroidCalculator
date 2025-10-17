package md.zibliuc.calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import md.zibliuc.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("ActivityMainBinding does not initialized")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnNumPadDot.setOnClickListener { writeToScreen(btnNumPadDot.text.toString()) }
            btnNumPadZero.setOnClickListener { writeToScreen(btnNumPadZero.text.toString()) }
            btnNumPadOne.setOnClickListener { writeToScreen(btnNumPadOne.text.toString()) }
            btnNumPadTwo.setOnClickListener { writeToScreen(btnNumPadTwo.text.toString()) }
            btnNumPadThree.setOnClickListener { writeToScreen(btnNumPadThree.text.toString()) }
            btnNumPadFour.setOnClickListener { writeToScreen(btnNumPadFour.text.toString()) }
            btnNumPadFive.setOnClickListener { writeToScreen(btnNumPadFive.text.toString()) }
            btnNumPadSix.setOnClickListener { writeToScreen(btnNumPadSix.text.toString()) }
            btnNumPadSeven.setOnClickListener { writeToScreen(btnNumPadSeven.text.toString()) }
            btnNumPadEight.setOnClickListener { writeToScreen(btnNumPadEight.text.toString()) }
            btnNumPadNine.setOnClickListener { writeToScreen(btnNumPadNine.text.toString()) }
            btnNumPadPlus.setOnClickListener { writeToScreen(btnNumPadPlus.text.toString()) }
            btnNumPadMinus.setOnClickListener { writeToScreen(btnNumPadMinus.text.toString()) }
            btnNumPadMultiple.setOnClickListener { writeToScreen(btnNumPadMultiple.text.toString()) }
            btnNumPadDivide.setOnClickListener { writeToScreen(btnNumPadDivide.text.toString()) }

            btnNumPadDelete.setOnClickListener { clearLastCharacter() }
            btnNumPadClearAll.setOnClickListener {
                binding.twCurrentInput.text = ""
                binding.twPreviousInput.text = ""
            }
        }
    }

    fun writeToScreen(item: String) {
        val currentText = binding.twCurrentInput.text.toString()
        binding.twCurrentInput.text = currentText.plus(item)
    }

    fun clearLastCharacter() {
        val deletedInput: CharSequence = binding.twCurrentInput.text.dropLast(1)
        binding.twCurrentInput.text = deletedInput
    }
}