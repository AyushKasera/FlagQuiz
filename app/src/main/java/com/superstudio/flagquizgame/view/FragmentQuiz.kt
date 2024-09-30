package com.superstudio.flagquizgame.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.superstudio.flagquizgame.databinding.FragmentQuizBinding
import com.superstudio.flagquizgame.database.DatabaseCopyHelper
import com.superstudio.flagquizgame.database.FlagDao
import com.superstudio.flagquizgame.model.FlagsModel

class FragmentQuiz : Fragment() {
    lateinit var fragmentQuizBinding: FragmentQuizBinding

    var flagList=ArrayList<FlagsModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentQuizBinding=FragmentQuizBinding.inflate(inflater,container,false)

        val dao= FlagDao()
        flagList=dao.getRandomTenRecords(DatabaseCopyHelper(requireActivity()),requireActivity())

        for(flags in flagList)
        {
            Toast.makeText(activity,"Something went wrong",Toast.LENGTH_SHORT).show()

            fragmentQuizBinding.buttonA.text=flags.countryName
            Log.d("flags : ",flags.id.toString())
            Log.d("flags : ",flags.countryName)
            Log.d("****************************************",flags.flagsName)
        }
        fragmentQuizBinding.buttonA.setOnClickListener {  }
        fragmentQuizBinding.buttonB.setOnClickListener {  }
        fragmentQuizBinding.buttonC.setOnClickListener {  }
        fragmentQuizBinding.buttonD.setOnClickListener {  }
        return fragmentQuizBinding.root
    }


}