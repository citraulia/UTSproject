package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Mendapatkan data dari Intent (dari ListFoodActivity)
        val foodName = intent.getStringExtra("FOOD_NAME")
        val foodNameTextView = findViewById<TextView>(R.id.etFoodName)
        foodNameTextView.text = foodName

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPlaceOrder = findViewById<Button>(R.id.btnOrder)
        btnPlaceOrder.setOnClickListener {
            // Ambil data dari EditText
            val servings = findViewById<EditText>(R.id.etServings).text.toString()
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val notes = findViewById<EditText>(R.id.etNotes).text.toString()

            // Kirim data ke ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("SERVINGS", servings)
                putExtra("NAME", name)
                putExtra("NOTES", notes)
            }
            startActivity(intent)
        }
    }
}