package com.superstudio.flagquizgame.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.superstudio.flagquizgame.databinding.FragmentHomeBinding
import com.superstudio.flagquizgame.database.DatabaseCopyHelper
import com.superstudio.flagquizgame.view.FragmentHomeDirections


class FragmentHome : Fragment() {


    lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding=FragmentHomeBinding.inflate(inflater,container,false)
        createAndOpenDataBase()

        fragmentHomeBinding.buttonStart.setOnClickListener {
        val direction=FragmentHomeDirections.actionFragmentHomeToFragmentQuiz()
            this.findNavController().navigate(direction)
        }

        return fragmentHomeBinding.root
    }
    private fun createAndOpenDataBase()
    {
        try {
            val helper= DatabaseCopyHelper(requireActivity())
            helper.createDataBase()
            helper.openDataBase()
        }
        catch (e: Exception)
        {
          //  Toast.makeText(activity,"Something went wrong",Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }


}