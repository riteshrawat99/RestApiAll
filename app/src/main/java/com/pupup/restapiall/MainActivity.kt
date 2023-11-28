package com.pupup.restapiall

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var frameLayout: FrameLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.fragmeLayout)
        replaceFragment(CommentFragment())
        val bottomNavigationView : BottomNavigationView=findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.comment->replaceFragment(CommentFragment())
                R.id.albums->replaceFragment(AlbumsFragment())
                R.id.photos->replaceFragment(PhotosFragment())
                R.id.todos->replaceFragment(TodosFragment())
                R.id.users->replaceFragment(UsersFragment())
            }
            true
        }

    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmeLayout,fragment).commit()
    }
}