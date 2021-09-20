package com.kirei.quizzes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class WonFragment : Fragment(R.layout.fragment_won) {

    private lateinit var wonBinding: FragmentWonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wonBinding = FragmentWonBinding.bind(view)
        wonBinding.btnFinish.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_wonFragment_to_welcomeFragment)
        )
    }
}