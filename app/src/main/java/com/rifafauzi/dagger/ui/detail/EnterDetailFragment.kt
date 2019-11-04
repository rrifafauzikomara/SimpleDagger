package com.rifafauzi.dagger.ui.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer

import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.registration.RegistrationActivity
import com.rifafauzi.dagger.ui.registration.RegistrationViewModel

/**
 * A simple [Fragment] subclass.
 */
class EnterDetailFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var enterDetailViewModel: EnterDetailViewModel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_enter_detail, container, false)
        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        enterDetailViewModel = EnterDetailViewModel()
        enterDetailViewModel.enterDetailState.observe(this,
            Observer<EnterDetailsViewState> { state ->
                when (state) {
                    is EnterDetailsSuccess -> {

                        val username = usernameEditText.text.toString()
                        val password = passwordEditText.text.toString()
                        registrationViewModel.updateUserData(username, password)

                        (activity as RegistrationActivity).onDetailEntered()
                    }
                    is EnterDetailsError -> {
                        errorTextView.text = state.error
                        errorTextView.visibility = View.VISIBLE
                    }
                }
            })
        initView(view)
        return view
    }

    private fun initView(view: View) {
        errorTextView = view.findViewById(R.id.tvError)

        usernameEditText = view.findViewById(R.id.etUsername)
        usernameEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        passwordEditText = view.findViewById(R.id.etPassword)
        passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            enterDetailViewModel.validateInput(username, password)
        }
    }

}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()