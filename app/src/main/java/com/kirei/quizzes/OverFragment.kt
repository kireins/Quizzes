package com.kirei.quizzes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class OverFragment : Fragment(R.layout.fragment_over) {

    private lateinit var overBinding: FragmentOverBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        overBinding = FragmentOverBinding.bind(view)
        overBinding.btnTryAgain.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_overFragment_to_welcomeFragment)
        )
    }