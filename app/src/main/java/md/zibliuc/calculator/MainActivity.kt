package md.zibliuc.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import md.zibliuc.calculator.core.validators.ServiceValidator
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
            // actions
            btnNumPadPlus.setOnClickListener { setOperation(btnNumPadPlus.text.toString()) }
            btnNumPadMinus.setOnClickListener { setOperation(btnNumPadMinus.text.toString()) }
            btnNumPadMultiple.setOnClickListener { setOperation(btnNumPadMultiple.text.toString()) }
            btnNumPadDivide.setOnClickListener { setOperation(btnNumPadDivide.text.toString()) }
            // equals
            btnNumPadEquals.setOnClickListener { calculate() }
            // clear
            btnNumPadDelete.setOnClickListener { clearLastCharacter() }
            btnNumPadClearAll.setOnClickListener { clearAll() }
            //test
            // glNumPad.setOnClickListener { clearAll() }
        }
    }

    fun writeToScreen(item: String) {
        val currentText = binding.twCurrentInput.text.toString()
        val newText = if (currentText == "0") item
                        else currentText.plus(item)

        if (ServiceValidator.validateCurrentInput(newText))
            binding.twCurrentInput.text = newText
    }

    fun setOperation(operation: String) {
        with (binding) {
            val currentInput = twCurrentInput.text.toString()
            val previousInput = twPreviousInput.text.toString()

            if (!currentInput.isBlank() ) {
                twPreviousInput.text = previousInput
                    .plus(currentInput.plus(operation))
                twCurrentInput.text = ""
            }
        }
    }

    fun calculate() {

        setOperation("=")
        binding.twCurrentInput.text = "result" //TODO: return of calculator class
    }

    fun clearAll() {
        with(binding) {
            twCurrentInput.text = ""
            twPreviousInput.text = ""
        }
    }

    fun clearLastCharacter() {
        val deletedInput: CharSequence = binding.twCurrentInput.text.dropLast(1)
        binding.twCurrentInput.text = deletedInput
    }
}