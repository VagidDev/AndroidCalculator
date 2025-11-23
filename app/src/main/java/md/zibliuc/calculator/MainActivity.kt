package md.zibliuc.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import md.zibliuc.calculator.core.app.Calculator
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

        savedInstanceState?.let {
            with(binding) {
                twPreviousInput.text = it.getString("previousText", "0")
                twCurrentInput.text = it.getString("currentText", "0")
            }
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("previousText", binding.twPreviousInput.text.toString())
        outState.putString("currentText", binding.twCurrentInput.text.toString())
    }

    fun writeToScreen(item: String) {
        if (binding.twPreviousInput.text.toString().contains("=")) {
            clearAll()
        }

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

            if (currentInput.isBlank()) {
                return
            }

            if (previousInput.contains("=")) {
                twPreviousInput.text = currentInput.plus(operation)
            } else {
                twPreviousInput.text = previousInput
                    .plus(currentInput.plus(operation))
            }
            twCurrentInput.text = ""
        }
    }

    fun calculate() {
        with(binding) {
            if (twPreviousInput.text.toString().contains("=")) {
                return
            }
            setOperation("=")
            val expression = twPreviousInput.text.toString()
            twCurrentInput.text = Calculator.calculate(expression) //TODO: return of calculator class
        }

    }

    fun clearAll() {
        with(binding) {
            twCurrentInput.text = "0"
            twPreviousInput.text = ""
        }
    }

    fun clearLastCharacter() {
        val currentText = binding.twCurrentInput.text.toString()

        if (currentText == "0") {
            return
        } else if (currentText.length == 1) {
            binding.twCurrentInput.text = "0"
            return
        }

        val deletedInput: CharSequence = currentText.dropLast(1)
        binding.twCurrentInput.text = deletedInput
    }
}