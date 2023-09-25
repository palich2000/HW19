package com.palich.hw19

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddFragment: Fragment(){
    private lateinit var viewModel: EmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            return inflater.inflate(
                R.layout.add_fragmant,
                container,
                false
            )

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(requireActivity()).get(EmployeeViewModel::class.java)
        val nameInput: EditText =view.findViewById(R.id.nameInputField)
        val positionInput: EditText =view.findViewById(R.id.positionInputField)
        val addButton: View =view.findViewById(R.id.addButton)

        addButton.setOnClickListener {
            Log.i("AddFragment", "addButton.setOnClickListener")
            Log.i("AddFragment", "nameInput.text.toString() = ${nameInput.text.toString()}")
            viewModel.add(nameInput.text.toString(), positionInput.text.toString())
            parentFragmentManager.popBackStack()
        }
    }

}