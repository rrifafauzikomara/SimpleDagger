package com.rifafauzi.dagger.ui.detail


import android.content.Context
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
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class EnterDetailFragment : Fragment() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    @Inject
    lateinit var enterDetailsViewModel: EnterDetailViewModel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Grabs the registrationComponent from the Activity and injects this Fragment
        (activity as RegistrationActivity).registrationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_enter_detail, container, false)

        enterDetailsViewModel.enterDetailState.observe(this,
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

        setupViews(view)
        return view
    }

    private fun setupViews(view: View) {
        errorTextView = view.findViewById(R.id.tvError)

        usernameEditText = view.findViewById(R.id.etUsername)
        usernameEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        passwordEditText = view.findViewById(R.id.etPassword)
        passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            enterDetailsViewModel.validateInput(username, password)
        }
    }
}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()