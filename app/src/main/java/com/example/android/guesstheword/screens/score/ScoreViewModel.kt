package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore:Int):ViewModel() {

    var finalScore= finalScore

    init{
        Log.i("ScoreViewModel", "ScoreViewModel Created!")
    }
}