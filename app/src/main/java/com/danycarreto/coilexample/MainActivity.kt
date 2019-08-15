package com.danycarreto.coilexample

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.Coil
import coil.ImageLoader
import coil.api.get
import coil.api.load
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.transform.CircleCropTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoilImageView.load(
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/26fc5604-06e5-4b51-9386-" +
                    "43c39000eafc/d8svycz-db555a41-414a-45d2-a9b5-ce4ebb4877b0.jpg/v1/fill/w_1127,h_709,q_70,strp/" +
                    "batman_dark_knight_returns_part_2_v2_by_angel_of_deathx1_d8svycz-pre.jpg?token=eyJ0eXAiOiJKV1QiL" +
                    "CJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJu" +
                    "OmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTIyNSIsInBhdGgiOiJcL2" +
                    "ZcLzI2ZmM1NjA0LTA2ZTUtNGI1MS05Mzg2LTQzYzM5MDAwZWFmY1wvZDhzdnljei1kYjU1NWE0MS00MTRhLTQ1ZDItYTliNS1jZTRlYm" +
                    "I0ODc3YjAuanBnIiwid2lkdGgiOiI8PTE5NDUifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.CD0bLZnduf" +
                    "fay2GVeeflvHFfxA30e5aiPW7GAPyIccc"
        ) {
            crossfade(true)
            placeholder(R.mipmap.ic_launcher)
            //transformations(CircleCropTransformation())
        }

        val imageLoader = ImageLoader(this) {
            componentRegistry {
                if (SDK_INT >= P) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
        }

        gifImageView.load("https://media.giphy.com/media/KkShWMoIwePpm/giphy.gif", imageLoader) {
            crossfade(true)
            placeholder(R.mipmap.ic_launcher)
            //transformations(CircleCropTransformation())
        }
    }
}
