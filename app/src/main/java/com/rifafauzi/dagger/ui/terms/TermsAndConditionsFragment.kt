package com.rifafauzi.dagger.ui.terms


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.registration.RegistrationActivity
import com.rifafauzi.dagger.ui.registration.RegistrationViewModel

/**
 * A simple [Fragment] subclass.
 */
class TermsAndConditionsFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)
        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        view.findViewById<Button>(R.id.btnRegister).setOnClickListener {
            registrationViewModel.acceptTCs()
            (activity as RegistrationActivity).onTermsAndConditionsAccepted()
        }
        return view
    }


}
