package com.example.pertemuan10

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan10.DetailedActivity.Companion.EXTRA_FRUIT
import com.example.pertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fruitsList: ArrayList<Fruit>
    private lateinit var fruitAdapter: FruitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fruitsList = ArrayList()

        fruitsList.add(Fruit(R.drawable.naga, R.drawable.naga, nama = "Naga", namaLatin = "Hylocereus polyrhizus", warna = "pink", keterangan = "Buah naga merah sebagai salah satu buah yang memiliki banyak manfaat untuk membantu mengatasi dan membantu menyembuhkan berbagai penyakit. Mulai dari batang buah naga, daging buah naga, sampai dengan kulit buah naga juga memiliki banyak kandungan vitamin dan zat yang sangat bermanfaat."))
        fruitsList.add(Fruit(R.drawable.anggurr, R.drawable.anggurr, nama = "Anggur", namaLatin = "Vitis Vinivera", warna = "purple", keterangan = "Buah ini juga dikenal mampu mencegah terbentuknya sel kanker dan berbagai penyakit lainnya. Aktivitas ini juga terkait dengan adanya senyawa metabolit sekunder di dalam buah anggur yang berperan sebagai senyawa antioksidan yang mampu menangkal radikal bebas."))
        fruitsList.add(Fruit(R.drawable.orange, R.drawable.orange, nama = "Sunkist", namaLatin = "Citrus sinensis", warna = "orange", keterangan = "Buah ini memiliki ciri khas yakni memiliki warna kulit oranye yang lebih tebal dan keras daripada jeruk biasanya. Jeruk sunkist merupakan buah yang rendah kalori dan kaya nutrisi. Seperti jeruk pada umumnya, jeruk sunkist mengandung sumber vitamin C yang tinggi. "))
        fruitsList.add(Fruit(R.drawable.duren, R.drawable.duren, nama = "Durian", namaLatin = "Durio zibethinus", warna = "yellow", keterangan = "Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri. Sebutan populernya adalah raja dari segala buah (King of Fruit). Durian adalah buah yang kontroversial, meskipun banyak orang yang menyukainya, tetapi sebagiannya kurang menyukai dengan aromanya."))
        fruitsList.add(Fruit(R.drawable.pom, R.drawable.pom, nama = "Delima", namaLatin = "Punica granatum", warna = "red", keterangan = "Buah dengan nama latin Punica granatum ini merupakan jenis buah yang masuk ke dalam kelompok berry. Buah delima diketahui mengandung berbagai nutrisi yang dibutuhkan oleh tubuh, seperti protein, karbohidrat, serat, dan vitamin, termasuk vitamin C, vitamin B kompleks, folat, vitamin E, serta vitamin K."))
        fruitsList.add(Fruit(R.drawable.mangga, R.drawable.mangga, nama = "Mangga", namaLatin = "Mangifera indica", warna = "orange", keterangan = "Buah mangga adalah buah tropis, sehingga dapat dengan mudah hidup dan tumbuh di Indonesia. Nama ilmiah mangga adalah Mangifera indica. Tercatat ada lebih dari 1.500 varietas mangga yang ada di dunia. Namun, terdapat sepuluh jenis mangga yang sangat populer di Indonesia."))

        fruitAdapter = FruitAdapter(fruitsList, this)
        with(binding) {
            rvFruits.apply {
                rvFruits.adapter = fruitAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

    }

    fun onItemClick(data: Fruit) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra(DetailedActivity.EXTRA_FRUIT, data)
        startActivity(intent)
    }

}