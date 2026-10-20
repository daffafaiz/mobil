package com.garasikita.app

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

private data class Vehicle(
    val name: String,
    val category: String,
    val tagline: String,
    val description: String,
    val extra: String,
    val image: Int,
)

class MainActivity : Activity() {
    private val cars = listOf(
        Vehicle("Supercar", "MOBIL • PERFORMA", "Cepat, lincah, dan penuh karakter", "Supercar memadukan kecepatan tinggi, teknologi modern, dan desain yang memikat. Dirancang untuk menghadirkan sensasi berkendara yang istimewa.", "Ciri khas: performa tinggi, bodi aerodinamis, dan teknologi berorientasi pengemudi.", R.drawable.ic_car),
        Vehicle("Hypercar", "MOBIL • PERFORMA EKSTREM", "Batas teratas teknologi otomotif", "Hypercar berada di puncak dunia performa. Setiap detailnya dirancang untuk mengejar kecepatan, efisiensi aerodinamika, dan pengalaman yang sangat eksklusif.", "Ciri khas: produksi terbatas, tenaga luar biasa, dan rekayasa kelas atas.", R.drawable.ic_car),
        Vehicle("Sports Car", "MOBIL • SPORT", "Dibuat untuk menikmati setiap tikungan", "Sports car membawa semangat balap ke jalan raya lewat pengendalian yang responsif dan keseimbangan yang menyenangkan.", "Ciri khas: posisi duduk rendah, pengendalian presisi, dan desain sporty.", R.drawable.ic_car),
        Vehicle("SUV", "MOBIL • SERBAGUNA", "Nyaman untuk kota dan perjalanan jauh", "SUV menawarkan kabin lega dan posisi berkendara lebih tinggi, cocok untuk perjalanan bersama keluarga maupun menjelajahi rute baru.", "Ciri khas: ruang kabin luas, fleksibel, dan ground clearance lebih tinggi.", R.drawable.ic_car),
        Vehicle("Sedan", "MOBIL • ELEGAN", "Kenyamanan dalam tampilan klasik", "Sedan mengutamakan kenyamanan penumpang dan pengendaraan yang halus dalam bentuk bodi tiga kompartemen yang elegan.", "Ciri khas: bagasi terpisah, kabin nyaman, dan karakter berkendara tenang.", R.drawable.ic_car),
        Vehicle("Electric Car", "MOBIL • ELEKTRIK", "Melaju senyap dengan tenaga listrik", "Mobil listrik menggunakan motor elektrik sebagai penggerak utama, memberikan akselerasi halus dan pengalaman berkendara yang senyap.", "Ciri khas: baterai isi ulang, tanpa emisi gas buang saat berkendara.", R.drawable.ic_car),
        Vehicle("Off-road 4×4", "MOBIL • PETUALANG", "Siap meninggalkan jalan beraspal", "Kendaraan off-road dirancang untuk menghadapi medan berat dengan traksi dan ground clearance yang mendukung petualangan.", "Ciri khas: penggerak empat roda, suspensi tangguh, ban untuk berbagai medan.", R.drawable.ic_car),
        Vehicle("Convertible", "MOBIL • GAYA HIDUP", "Nikmati perjalanan dengan atap terbuka", "Convertible menawarkan pengalaman perjalanan yang lebih dekat dengan suasana sekitar berkat atap yang bisa dibuka.", "Ciri khas: atap lipat atau lepas dan siluet yang khas.", R.drawable.ic_car),
    )

    private val bikes = listOf(
        Vehicle("Superbike", "MOTOR • PERFORMA", "DNA sirkuit untuk jalan raya", "Superbike membawa karakter motor balap dengan performa tinggi dan posisi berkendara yang agresif.", "Ciri khas: fairing penuh, mesin bertenaga, dan aerodinamika sport.", R.drawable.ic_bike),
        Vehicle("Naked Bike", "MOTOR • SPORT", "Gaya tegas dan kendali praktis", "Naked bike menggabungkan karakter sporty dengan posisi berkendara yang lebih tegak dan nyaman untuk keseharian.", "Ciri khas: mesin terekspos, posisi santai, dan desain minimalis.", R.drawable.ic_bike),
        Vehicle("Adventure", "MOTOR • PETUALANG", "Jelajahi lebih dari sekadar aspal", "Motor adventure dibuat untuk perjalanan jauh dan berbagai kondisi jalan, dari perkotaan hingga jalur yang menantang.", "Ciri khas: suspensi panjang, posisi tegak, dan kapasitas touring.", R.drawable.ic_bike),
        Vehicle("Cruiser", "MOTOR • KLASIK", "Santai menikmati setiap kilometer", "Cruiser mengutamakan kenyamanan dan karakter berkendara yang rileks dengan desain klasik yang ikonik.", "Ciri khas: jok rendah, setang lebar, dan posisi kaki ke depan.", R.drawable.ic_bike),
        Vehicle("Scooter", "MOTOR • HARIAN", "Lincah untuk rutinitas kota", "Scooter praktis digunakan sehari-hari berkat transmisi yang mudah, dek kaki rata, dan ruang penyimpanan yang berguna.", "Ciri khas: transmisi otomatis, praktis, dan nyaman untuk perkotaan.", R.drawable.ic_bike),
        Vehicle("Cafe Racer", "MOTOR • RETRO", "Sentuhan klasik yang personal", "Cafe racer terinspirasi dari motor balap klasik dengan gaya sederhana yang mengutamakan karakter dan detail.", "Ciri khas: siluet ramping, jok khas, dan tampilan retro.", R.drawable.ic_bike),
        Vehicle("Motocross", "MOTOR • OFF-ROAD", "Lincah menaklukkan jalur tanah", "Motocross dirancang untuk jalur off-road dan lintasan tanah, dengan konstruksi ringan dan suspensi yang siap menghadapi lompatan.", "Ciri khas: ban bertapak dalam, bobot ringan, tanpa perlengkapan jalan umum.", R.drawable.ic_bike),
        Vehicle("Electric Bike", "MOTOR • ELEKTRIK", "Perjalanan senyap untuk masa depan", "Motor listrik memakai baterai sebagai sumber energi dan menghadirkan pengendaraan yang senyap untuk perjalanan harian.", "Ciri khas: penggerak elektrik, pengisian daya, dan perawatan praktis.", R.drawable.ic_bike),
    )

    private var showingCars = true
    private var query = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showCatalog()
    }

    private fun showCatalog() {
        setContentView(R.layout.activity_main)
        val list = findViewById<LinearLayout>(R.id.vehicleList)
        val title = findViewById<TextView>(R.id.sectionTitle)
        val search = findViewById<EditText>(R.id.searchInput)
        val carsButton = findViewById<Button>(R.id.carsButton)
        val bikesButton = findViewById<Button>(R.id.bikesButton)

        fun render() {
            val items = if (showingCars) cars else bikes
            title.text = if (showingCars) "PILIH KELAS MOBIL" else "PILIH KELAS MOTOR"
            carsButton.setBackgroundTintList(getColorStateList(if (showingCars) R.color.accent else R.color.surface))
            bikesButton.setBackgroundTintList(getColorStateList(if (showingCars) R.color.surface else R.color.accent))
            carsButton.setTextColor(getColor(if (showingCars) R.color.ink else android.R.color.white))
            bikesButton.setTextColor(getColor(if (showingCars) android.R.color.white else R.color.ink))
            list.removeAllViews()
            val matching = items.filter { it.name.contains(query.trim(), ignoreCase = true) || it.tagline.contains(query.trim(), ignoreCase = true) }
            matching.forEach { vehicle ->
                val row = LayoutInflater.from(this).inflate(R.layout.item_vehicle, list, false)
                row.findViewById<ImageView>(R.id.vehicleImage).setImageResource(vehicle.image)
                row.findViewById<TextView>(R.id.vehicleType).text = vehicle.category
                row.findViewById<TextView>(R.id.vehicleName).text = vehicle.name
                row.findViewById<TextView>(R.id.vehicleDescription).text = vehicle.tagline
                row.setOnClickListener { showDetail(vehicle) }
                list.addView(row)
            }
            if (matching.isEmpty()) {
                val empty = TextView(this).apply {
                    text = "Belum ada hasil. Coba kata pencarian lain."
                    setTextColor(getColor(R.color.muted))
                    textSize = 14f
                    setPadding(4, 20, 4, 20)
                }
                list.addView(empty)
            }
        }

        carsButton.setOnClickListener { showingCars = true; render() }
        bikesButton.setOnClickListener { showingCars = false; render() }
        search.setText(query)
        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { query = s?.toString().orEmpty(); render() }
            override fun afterTextChanged(s: Editable?) = Unit
        })
        render()
    }

    private fun showDetail(vehicle: Vehicle) {
        setContentView(R.layout.activity_detail)
        findViewById<TextView>(R.id.detailType).text = vehicle.category
        findViewById<TextView>(R.id.detailName).text = vehicle.name
        findViewById<ImageView>(R.id.detailImage).setImageResource(vehicle.image)
        findViewById<TextView>(R.id.detailDescription).text = vehicle.description
        findViewById<TextView>(R.id.detailExtra).text = vehicle.extra
        findViewById<Button>(R.id.backButton).setOnClickListener { showCatalog() }
    }

    @Deprecated("Use the onBackPressedDispatcher for new activity navigation")
    override fun onBackPressed() {
        showCatalog()
    }
}
