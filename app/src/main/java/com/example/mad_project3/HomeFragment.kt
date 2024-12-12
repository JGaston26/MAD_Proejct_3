package com.example.mad_project3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.navigation.NavController
import androidx.navigation.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    private var userFavorite : EditText? = null
    @OptIn(UnstableApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragOneButton: Button = view.findViewById(R.id.fragOneButton)
        userFavorite = view.findViewById(R.id.editText)
        savedInstanceState?.getString("currentText").let{
            userFavorite?.setText(it)
        }

        fragOneButton.setOnClickListener {
            val userFaveWebsiteText : String = userFavorite?.text.toString()
            Log.i("Hello",userFaveWebsiteText)
            val passedData : Bundle = Bundle()
            passedData.putString("usrFavWeb", userFaveWebsiteText)
            val navController: NavController = view.findNavController()
            navController.navigate(R.id.action_homeFragment_to_secondFrag, passedData)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        userFavorite?.text?.toString()?.let{
            outState.putString("currentText", it)
        }
    }

}