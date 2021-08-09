package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var gameActive:Boolean=true
//Player Representations
    //0 - x
    //1 - 0

    var activePlayer:Int=0
    var gameState: Array<Int> = arrayOf(2,2,2,2,2,2,2,2,2,2)
    //  State Meanings
    // 0 - x
    // 1 - o
    // 2 - Null

    var winPositions = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9),
                      intArrayOf(1, 4, 7),intArrayOf(2, 5, 8),intArrayOf(3, 6, 9),
                      intArrayOf(1, 5, 9),intArrayOf(3, 5, 7))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playertap(view: View) {
        var img:ImageView=view as ImageView
        var tappedImage:Int = Integer.parseInt(img.getTag().toString())


        if(gameState[tappedImage] ==2 && gameActive==true)
        {
            gameState[tappedImage]=activePlayer
//            img.translationY.apply { -1000f }

            if (activePlayer ==0)
            {
                img.setImageResource(R.drawable.x)
                activePlayer=1
                status.setText("O's turn! tap to play")
            }
            else{

                img.setImageResource(R.drawable.o)
                activePlayer=0
                status.setText("X's turn! tap to play")
            }
        }
        else if(gameActive == false)
        {
            Gamereset()
        }
        //Check if any player has won

        for(winPositions in winPositions)
        {
           if( gameState[winPositions[0]]== gameState[winPositions[1]] &&
               gameState[winPositions[1]]== gameState[winPositions[2]] &&
                   gameState[winPositions[0]]!=2){

               Log.d("message", gameState[winPositions[0]].toString()+" "+gameState[winPositions[1]].toString()+" "+gameState[winPositions[1]].toString()+" "+gameState[winPositions[2]].toString())
               var winnerStr:String
                  gameActive=false
               if(gameState[winPositions[0]] ==0)
               {
                   winnerStr = "X has won"
               }
               else
               {
                   winnerStr = "O has Won"
               }

               status.setText(winnerStr)
           }
        }



//        img.translationY.apply { 1000f }
//        img.animate().translationYBy(1000f).setDuration(300)

    }

    fun Gamereset()
    {
        gameActive=true
        activePlayer=0

        for(i in 0..gameState.size-1)
        {
            gameState[i]=2
        }

        findViewById<ImageView>(R.id.imageView1).setImageResource(0)
        findViewById<ImageView>(R.id.imageView2).setImageResource(0)
        findViewById<ImageView>(R.id.imageView3).setImageResource(0)
        findViewById<ImageView>(R.id.imageView4).setImageResource(0)
        findViewById<ImageView>(R.id.imageView5).setImageResource(0)
        findViewById<ImageView>(R.id.imageView6).setImageResource(0)
        findViewById<ImageView>(R.id.imageView7).setImageResource(0)
        findViewById<ImageView>(R.id.imageView8).setImageResource(0)
        findViewById<ImageView>(R.id.imageView9).setImageResource(0)
        status.setText("X's turn! tap to play")

    }
}