package com.example.severalactivities

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.severalactivities.databinding.ActivityActiv2Binding

class activ2 : AppCompatActivity() {
    private lateinit var binding: ActivityActiv2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityActiv2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //получаем список аргументов, присланных из первого активити
        //и если эти аргументы не null, то обрабатываем
        val arguments = intent.extras
        var name: String = "default"
        var age: Int = 10
        if(arguments!=null) {
            //метод get позволяет получить значение по ключу
            name = arguments.get("name").toString()
            age = arguments.get("age").toString().toInt()
        }
        binding.textView2.text = binding.textView2.text.toString()+", "+name+", возраст "+age.toString()

        val btn_toact1 = binding.button1
        btn_toact1.setOnClickListener{
            val act1_start = Intent(this, MainActivity::class.java)
            startActivity(act1_start)
        }
                val btnRotate = binding.rotateBtn
        val imageUserImageView: ImageView = findViewById(R.id.image)
        btnRotate.setOnClickListener{
            val rotateAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_center)
            imageUserImageView.startAnimation(rotateAnimation)
        }
        val btnRotate2 = binding.rotateBtn2
        btnRotate2.setOnClickListener{

            val rotateAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_angle)
            imageUserImageView.startAnimation(rotateAnimation)
        }
        fun muchFood(){
            val rotateAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_center)
            imageUserImageView.startAnimation(rotateAnimation)
            val rotateAnimation2: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_angle)
            imageUserImageView.startAnimation(rotateAnimation2)
        }
        var food = 20
        val labelFood = "Еда: "
        binding.textFood.text = labelFood+food
        val btnEat = binding.btnEat
        btnEat .setOnClickListener{
            food+=10
            binding.textFood.text = labelFood+food
            if(food>=110){
                muchFood()
            }
        }

    }
}