package com.superstudio.flagquizgame.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.superstudio.flagquizgame.R
import com.superstudio.flagquizgame.databinding.FragmentResultBinding


class FragmentResult : Fragment() {

    private lateinit var fragmentResultBinding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentResultBinding=FragmentResultBinding.inflate(inflater,container,false)
        fragmentResultBinding.buttonNextQuiz.setOnClickListener {  }
        fragmentResultBinding.buttonExit.setOnClickListener {  }
        return fragmentResultBinding.root
    }


}