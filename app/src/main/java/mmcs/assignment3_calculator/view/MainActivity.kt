package mmcs.assignment3_calculator.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import mmcs.assignment3_calculator.R
import mmcs.assignment3_calculator.databinding.ActivityMainBinding
import mmcs.assignment3_calculator.viewmodel.CalculatorViewModel
import mmcs.assignment3_calculator.viewmodel.Operation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListenners()

        viewModel.display.observe(this) {
            binding.etDisplay.setText(it)
        }
    }
    fun makeToast() {
        Toast.makeText(this, "", Toast.LENGTH_LONG)
    }

    private fun setListenners() {
        binding.b0.setOnClickListener {
            viewModel.addDigit(0)
        }
        binding.b1.setOnClickListener {
            viewModel.addDigit(1)
        }
        binding.b2.setOnClickListener {
            viewModel.addDigit(2)
        }
        binding.b3.setOnClickListener {
            viewModel.addDigit(3)
        }
        binding.b4.setOnClickListener {
            viewModel.addDigit(4)
        }
        binding.b5.setOnClickListener {
            viewModel.addDigit(5)
        }
        binding.b6.setOnClickListener {
            viewModel.addDigit(6)
        }
        binding.b7.setOnClickListener {
            viewModel.addDigit(7)
        }
        binding.b8.setOnClickListener {
            viewModel.addDigit(8)
        }
        binding.b9.setOnClickListener {
            viewModel.addDigit(9)
        }
        binding.bDot.setOnClickListener {
            viewModel.addPoint()
        }
        binding.bEquel.setOnClickListener {
            viewModel.compute()
        }
        binding.bDel.setOnClickListener {
            viewModel.clear()
        }
        binding.bDiv.setOnClickListener {
            viewModel.addOperation(Operation.DIV)
        }
        binding.bMultiply.setOnClickListener {
            viewModel.addOperation(Operation.MUL)
        }
        binding.bPlus.setOnClickListener {
            viewModel.addOperation(Operation.ADD)
        }
        binding.bMinus.setOnClickListener {
            viewModel.addOperation(Operation.SUB)
        }
    }
}