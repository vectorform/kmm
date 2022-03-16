package com.example.kmmshared.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.JokeAPI
import com.example.kmmshared.android.databinding.FragmentJokeBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class JokeFragment : Fragment(), CoroutineScope, View.OnClickListener {

    private var viewBinding: FragmentJokeBinding? = null
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.apply {
            buttonLoginGetJoke.setOnClickListener(this@JokeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentJokeBinding.inflate(inflater)
        return viewBinding?.root
    }

    private fun getJoke() {
        launch {
            try {
                setContentString("getting joke...")
                val joke = JokeAPI().getJoke()
                withContext(Dispatchers.Main) { setContentString(joke.toString()) }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) { handleException(exception) }
            }
        }
    }

    private fun setContentString(string: String) {
        viewBinding?.apply {
            textLoginResult.text = string
        }
    }

    private fun handleException(exception: Exception) {
        viewBinding?.apply {
            textLoginResult.text = exception.message
        }
    }

    // View.OnClickListener
    override fun onClick(view: View?) {
        viewBinding?.apply {
            when (view) {
                buttonLoginGetJoke -> getJoke()
            }
        }
    }
}