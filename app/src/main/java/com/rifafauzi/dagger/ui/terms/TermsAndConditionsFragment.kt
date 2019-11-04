package com.rifafauzi.dagger.ui.terms


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.rifafauzi.dagger.MyApplication

import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.registration.RegistrationActivity
import com.rifafauzi.dagger.ui.registration.RegistrationViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TermsAndConditionsFragment : Fragment() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

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
        val view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)

        view.findViewById<Button>(R.id.btnRegister).setOnClickListener {
            registrationViewModel.acceptTCs()
            (activity as RegistrationActivity).onTermsAndConditionsAccepted()
        }

        return view
    }
}