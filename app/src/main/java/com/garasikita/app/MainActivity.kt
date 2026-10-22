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
    val model: String,
    val category: String,
    val tagline: String,
    val description: String,
    val extra: String,
    val image: Int,
)

class MainActivity : Activity() {
    private val cars = listOf(
        Vehicle("Supercar", "Lamborghini Huracán", "MOBIL • PERFORMA", "Cepat, lincah, dan penuh karakter", "Lamborghini Huracán adalah contoh supercar bermesin tengah yang memadukan performa tinggi dengan desain yang memikat.", "Kelas: Supercar. Ciri khas: bodi aerodinamis, mesin bertenaga, dan teknologi berorientasi pengemudi.", R.drawable.car_supercar),
        Vehicle("Hypercar", "Bugatti Chiron", "MOBIL • PERFORMA EKSTREM", "Batas teratas teknologi otomotif", "Bugatti Chiron adalah contoh hypercar produksi yang mengejar kecepatan, efisiensi aerodinamika, dan pengalaman yang sangat eksklusif.", "Kelas: Hypercar. Ciri khas: produksi terbatas, tenaga luar biasa, dan rekayasa kelas atas.", R.drawable.car_hypercar),
        Vehicle("Sports Car", "Porsche 911", "MOBIL • SPORT", "Dibuat untuk menikmati setiap tikungan", "Porsche 911 membawa semangat mobil sport ke jalan raya lewat pengendalian yang responsif dan keseimbangan yang menyenangkan.", "Kelas: Sports Car. Ciri khas: posisi duduk rendah, pengendalian presisi, dan desain sporty.", R.drawable.car_sports),
        Vehicle("SUV", "Jeep Wrangler", "MOBIL • SERBAGUNA", "Nyaman untuk kota dan perjalanan jauh", "Jeep Wrangler adalah contoh SUV tangguh dengan kabin lega dan kemampuan menjelajahi berbagai rute.", "Kelas: SUV. Ciri khas: ruang kabin fleksibel, posisi berkendara tinggi, dan ground clearance tinggi.", R.drawable.car_suv),
        Vehicle("Sedan", "BMW 3 Series", "MOBIL • ELEGAN", "Kenyamanan dalam tampilan klasik", "BMW 3 Series menjadi contoh sedan yang mengutamakan kenyamanan penumpang dan pengendaraan yang halus.", "Kelas: Sedan. Ciri khas: bagasi terpisah, kabin nyaman, dan karakter berkendara tenang.", R.drawable.car_sedan),
        Vehicle("Electric Car", "Tesla Model S", "MOBIL • ELEKTRIK", "Melaju senyap dengan tenaga listrik", "Tesla Model S menggunakan penggerak elektrik untuk memberikan akselerasi halus dan pengalaman berkendara yang senyap.", "Kelas: Mobil listrik. Ciri khas: baterai isi ulang dan tanpa emisi gas buang saat berkendara.", R.drawable.car_electric),
        Vehicle("Off-road 4×4", "Toyota Land Cruiser", "MOBIL • PETUALANG", "Siap meninggalkan jalan beraspal", "Toyota Land Cruiser dirancang untuk menghadapi medan berat dengan traksi dan ground clearance yang mendukung petualangan.", "Kelas: Off-road 4×4. Ciri khas: penggerak empat roda, suspensi tangguh, dan ban untuk berbagai medan.", R.drawable.car_offroad),
        Vehicle("Convertible", "Mazda MX-5 Miata", "MOBIL • GAYA HIDUP", "Nikmati perjalanan dengan atap terbuka", "Mazda MX-5 Miata adalah roadster ringan dengan atap yang dapat dibuka untuk menikmati suasana perjalanan.", "Kelas: Convertible. Ciri khas: atap lipat dan siluet roadster yang khas.", R.drawable.car_convertible),
    )

    private val bikes = listOf(
        Vehicle("Superbike", "Kawasaki Ninja", "MOTOR • PERFORMA", "DNA sirkuit untuk jalan raya", "Kawasaki Ninja menjadi contoh motor sport berfairing penuh dengan performa tinggi dan posisi berkendara agresif.", "Kelas: Superbike. Ciri khas: fairing penuh, mesin bertenaga, dan aerodinamika sport.", R.drawable.bike_superbike),
        Vehicle("Naked Bike", "Kawasaki Z900", "MOTOR • SPORT", "Gaya tegas dan kendali praktis", "Kawasaki Z900 menggabungkan karakter sporty dengan posisi berkendara tegak dan mesin yang terekspos.", "Kelas: Naked Bike. Ciri khas: mesin terekspos, posisi santai, dan desain minimalis.", R.drawable.bike_naked),
        Vehicle("Adventure", "BMW R 1250 GS", "MOTOR • PETUALANG", "Jelajahi lebih dari sekadar aspal", "BMW R 1250 GS dibuat untuk perjalanan jauh dan berbagai kondisi jalan, dari perkotaan hingga jalur menantang.", "Kelas: Adventure. Ciri khas: suspensi panjang, posisi tegak, dan kapasitas touring.", R.drawable.bike_adventure),
        Vehicle("Cruiser", "Harley-Davidson Cruiser", "MOTOR • KLASIK", "Santai menikmati setiap kilometer", "Cruiser Harley-Davidson mengutamakan kenyamanan dan karakter berkendara rileks dengan desain klasik ikonik.", "Kelas: Cruiser. Ciri khas: jok rendah, setang lebar, dan posisi kaki ke depan.", R.drawable.bike_cruiser),
        Vehicle("Scooter", "Vespa", "MOTOR • HARIAN", "Lincah untuk rutinitas kota", "Vespa adalah contoh skuter bergaya klasik yang praktis untuk aktivitas harian di perkotaan.", "Kelas: Scooter. Ciri khas: transmisi otomatis, praktis, dan nyaman untuk perkotaan.", R.drawable.bike_scooter),
        Vehicle("Cafe Racer", "Honda CB400 Cafe Racer", "MOTOR • RETRO", "Sentuhan klasik yang personal", "Honda CB400 modifikasi cafe racer terinspirasi motor balap klasik dengan gaya sederhana dan personal.", "Kelas: Cafe Racer. Ciri khas: siluet ramping, jok khas, dan tampilan retro.", R.drawable.bike_cafe),
        Vehicle("Motocross", "Motorcross", "MOTOR • OFF-ROAD", "Lincah menaklukkan jalur tanah", "Motorcross dirancang untuk lintasan tanah dengan konstruksi ringan dan suspensi yang siap menghadapi lompatan.", "Kelas: Motocross. Ciri khas: ban bertapak dalam, bobot ringan, dan suspensi panjang.", R.drawable.bike_motocross),
        Vehicle("Electric Bike", "Zero S", "MOTOR • ELEKTRIK", "Perjalanan senyap untuk masa depan", "Zero S memakai baterai sebagai sumber energi dan menghadirkan pengendaraan senyap untuk perjalanan harian.", "Kelas: Motor listrik. Ciri khas: penggerak elektrik dan pengisian daya baterai.", R.drawable.bike_electric),
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
            val matching = items.filter { it.name.contains(query.trim(), ignoreCase = true) || it.model.contains(query.trim(), ignoreCase = true) || it.tagline.contains(query.trim(), ignoreCase = true) }
            matching.forEach { vehicle ->
                val row = LayoutInflater.from(this).inflate(R.layout.item_vehicle, list, false)
                row.findViewById<ImageView>(R.id.vehicleImage).apply {
                    setImageResource(vehicle.image)
                    contentDescription = "Foto ${vehicle.model}"
                }
                row.findViewById<TextView>(R.id.vehicleType).text = vehicle.category
                row.findViewById<TextView>(R.id.vehicleName).text = vehicle.model
                row.findViewById<TextView>(R.id.vehicleDescription).text = "${vehicle.name} · ${vehicle.tagline}"
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
        findViewById<TextView>(R.id.detailType).text = "${vehicle.category}  •  ${vehicle.name.uppercase()}"
        findViewById<TextView>(R.id.detailName).text = vehicle.model
        findViewById<ImageView>(R.id.detailImage).apply {
            setImageResource(vehicle.image)
            contentDescription = "Foto ${vehicle.model}"
        }
        findViewById<TextView>(R.id.detailDescription).text = vehicle.description
        findViewById<TextView>(R.id.detailExtra).text = vehicle.extra
        findViewById<Button>(R.id.backButton).setOnClickListener { showCatalog() }
    }

    @Deprecated("Use the onBackPressedDispatcher for new activity navigation")
    override fun onBackPressed() {
        showCatalog()
    }
}
