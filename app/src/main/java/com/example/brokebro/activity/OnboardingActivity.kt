package com.example.brokebro.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.brokebro.R
import com.example.brokebro.adapters.OnboardingAdapter
import com.example.brokebro.databinding.ActivityOnboardingBinding
import com.example.brokebro.models.OnboardingItem


class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var adapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data for pages
        val items = listOf(
            OnboardingItem(R.drawable.intro_img_0,"Welcome to BrokeBro","Your ultimate student savings companion—unlock verified discounts across life essentials, fashion, tech, travel, and more. Save while you study and make every penny count!"),
            OnboardingItem(R.drawable.intro_img_1, "Exclusive Discounts Just for You", "Enjoy unbeatable student deals on brands like Nike, Adidas, Figma, Canva, and Lenovo. Stay savvy and stylish without breaking the bank."),
            OnboardingItem(R.drawable.intro_img_2, "Internships & Career Boosters", "Access top-tier internships at leading companies. Gain hands-on experience, grow your skills, and kickstart your career through trusted opportunities."),
            OnboardingItem(R.drawable.intro_img_3, "Refer, Earn Coins ", "Invite friends, earn rewards, and join a community dedicated to helping students thrive. BrokeBro is made by students, for students—let’s uplift each other.")
        )
        adapter = OnboardingAdapter(items)
        binding.viewPager.adapter = adapter

        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < adapter.itemCount) {
                binding.viewPager.currentItem += 1
            }
            else {
                // Last screen -> go to MainActivity
                startActivity(Intent(this, RoleActivity::class.java))
            }
        }

        val dotsIndicator = binding.dotsIndicator
        dotsIndicator.attachTo(binding.viewPager)

        binding.btnSkip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}
