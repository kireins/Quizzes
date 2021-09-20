package com.kirei.quizzes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation


class OverFragment : Fragment() {

    private lateinit var overBinding: FragmentOverBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        overBinding = FragmentOverBinding.inflate(inflater, container, false)
        return overBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        overBinding.btnTryAgain.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_overFragment_to_welcomeFragment))
    }

}