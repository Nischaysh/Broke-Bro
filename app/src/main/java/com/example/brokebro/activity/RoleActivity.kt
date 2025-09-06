package com.example.brokebro.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.brokebro.R
import com.example.brokebro.databinding.ActivityRoleBinding
import com.example.brokebro.startHeroTransition
import com.google.android.material.card.MaterialCardView

class RoleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()


        // Initial selected state
        var selectedCard: MaterialCardView? = null

        // Click listener for Student Card
        binding.studentCard.setOnClickListener {
            selectCard(binding.studentCard, binding.businessCard)
            selectedCard = binding.studentCard
        }

        // Click listener for Business Card
        binding.businessCard.setOnClickListener {
            selectCard(binding.businessCard, binding.studentCard)
            selectedCard = binding.businessCard
        }
        binding.tvLogin.setOnClickListener {
            binding.studentCard.startHeroTransition(
                this,
                LoginActivity::class.java,
                "hero_view",

            )
        }

        // Continue button click (optional)
        binding.continueButton.setOnClickListener {
            selectedCard?.let {
                if (it == binding.studentCard) {
                    Toast.makeText(this, "Student selected", Toast.LENGTH_SHORT).show()
                    binding.studentCard.startHeroTransition(
                        this,
                        StudentSigninActivity::class.java,
                        "hero_view",
                        mapOf(
                            "Role" to "Student"
                        )
                    )
                } else if (it == binding.businessCard) {
                    Toast.makeText(this, "Business selected", Toast.LENGTH_SHORT).show()
                    binding.businessCard.startHeroTransition(
                        this,
                        BusinessSigninActivity::class.java,
                        "hero_view",
                        mapOf(
                            "Role" to "Business"
                        )
                    )
                }
            } ?: Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to highlight the selected card
    private fun selectCard(selected: MaterialCardView, unselected: MaterialCardView) {
        val selectedColor = ContextCompat.getColor(this, R.color.primary) // highlight color
        val unselectedColor = ContextCompat.getColor(this, R.color.border_color) // default border

        selected.strokeColor = selectedColor
        unselected.strokeColor = unselectedColor
    }

}