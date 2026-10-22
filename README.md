# Project Mobile App (tema yang saya ambil itu Applikasi untuk pilih Kendaraan) Nama Applikasi GarasiKita
Nama : Daffa Syafiq Faiz
NIM : 24091006

# GarasiKita

Aplikasi katalog kendaraan Android dengan Kotlin dan tampilan XML. Tema mobil dan motor dipilih karena mudah diperagakan dalam dua layar: katalog kategori dan halaman detail.

## Fitur

- Dua kategori utama: mobil dan motor.
- Delapan kelas untuk setiap kategori, termasuk Supercar, Hypercar, Superbike, dan Adventure.
- Contoh model nyata pada setiap kelas, seperti Lamborghini Huracán, Bugatti Chiron, Kawasaki Ninja, dan Vespa.
- Pencarian nama kelas, merek, dan model.
- Halaman detail dengan foto, ringkasan, dan ciri khas setiap kelas.
- Tombol kembali dan tampilan gelap beraksen hijau.
- Berjalan offline; foto disimpan di dalam aplikasi dan tidak memerlukan izin internet.

## Layar

1. **Katalog** — pilih Mobil atau Motor, cari kelas kendaraan, lalu ketuk kartu untuk membuka detail.
2. **Detail** — melihat foto model contoh, membaca ringkasan kelas kendaraan, dan kembali ke katalog.

## Cara menjalankan di Android Studio

1. Pasang Android Studio dan komponen Android SDK Platform 35 serta Android SDK Build-Tools yang direkomendasikan oleh Android Studio.
2. Buka folder proyek ini di Android Studio dan tunggu Gradle menyelesaikan sinkronisasi (internet dibutuhkan pertama kali untuk mengunduh plugin dan Gradle 8.9).
3. Sambungkan HP Android dengan USB, aktifkan **Opsi pengembang** dan **USB debugging**, lalu izinkan komputer saat prompt muncul di HP.
4. Pilih perangkat HP di daftar perangkat Android Studio, kemudian tekan **Run ▶**.

## Membuat APK untuk dipasang di HP

Di Android Studio, pilih **Build → Build Bundle(s) / APK(s) → Build APK(s)**. APK debug akan berada di `app/build/outputs/apk/debug/app-debug.apk`. Pindahkan APK ke HP dan buka file tersebut untuk memasang. Android mungkin meminta izin memasang aplikasi dari sumber itu.

Build dari terminal VS Code, setelah `local.properties` menunjuk ke lokasi Android SDK yang benar:

```powershell
.\gradlew.bat assembleDebug
```

Untuk memasang APK dari komputer dengan Android SDK Platform-Tools:

```powershell
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Screenshot untuk pengumpulan

<p align="center">
  <img src="katalog.jpeg" alt="Layar katalog kendaraan" width="220">
  <img src="detail.jpeg" alt="Layar detail kendaraan" width="220">
</p>

## Sumber dan atribusi foto

Foto kendaraan berasal dari Wikimedia Commons, bukan gambar hasil generasi AI. Foto diubah ukurannya dan dipotong agar sesuai dengan tampilan aplikasi. File disimpan lokal di `app/src/main/res/drawable-nodpi/`, jadi tetap muncul saat aplikasi dipakai tanpa internet.

### Mobil

- Supercar — [Lamborghini Huracan 11.jpg](https://commons.wikimedia.org/wiki/File:Lamborghini_Huracan_11.jpg), Calreyn88, CC BY 4.0.
- Hypercar — [Bugatti Chiron 2017.jpg](https://commons.wikimedia.org/wiki/File:Bugatti_Chiron_2017.jpg), MrWalkr, CC BY-SA 4.0.
- Sports car — [Porsche 911 991.jpg](https://commons.wikimedia.org/wiki/File:Porsche_911_991.jpg), Calreyn88, CC BY-SA 4.0.
- SUV — [Jeep Wrangler.jpg](https://commons.wikimedia.org/wiki/File:Jeep_Wrangler.jpg), FotoSleuth, CC BY 2.0.
- Sedan — [BMW 3 Series 3.jpg](https://commons.wikimedia.org/wiki/File:BMW_3_Series_3.jpg), Calreyn88, CC BY-SA 4.0.
- Mobil listrik — [2024 Tesla Model S.jpg](https://commons.wikimedia.org/wiki/File:2024_Tesla_Model_S.jpg), Calreyn88, CC BY-SA 4.0.
- Off-road — [1991 Toyota Land Cruiser.jpg](https://commons.wikimedia.org/wiki/File:1991_Toyota_Land_Cruiser.jpg), Calreyn88, CC BY-SA 4.0.
- Convertible — [Mazda MX-5 Miata NA.jpg](https://commons.wikimedia.org/wiki/File:Mazda_MX-5_Miata_NA.jpg), Tronerud, CC BY-SA 4.0.

### Motor

- Superbike — [Kawasaki Ninja.jpg](https://commons.wikimedia.org/wiki/File:Kawasaki_Ninja.jpg), Calreyn88, CC BY-SA 4.0.
- Naked bike — [KawasakiZ900.jpg](https://commons.wikimedia.org/wiki/File:KawasakiZ900.jpg), T.doi.z900, CC BY-SA 4.0.
- Adventure — [BMW R1250 GS Motorbike.jpg](https://commons.wikimedia.org/wiki/File:BMW_R1250_GS_Motorbike.jpg), TaurusEmerald, CC BY-SA 4.0.
- Cruiser — [Harley Davidson Cruiser and Touring bike](https://commons.wikimedia.org/wiki/File:Harley_Davidson_Cruiser_and_Touring_bike_%28parked%29_-_Ride_for_Kids_Las_vegas_2019.jpg), Noah Wulf, CC BY-SA 4.0.
- Scooter — [Amsterdam - Vespa scooter - 0332.jpg](https://commons.wikimedia.org/wiki/File:Amsterdam_-_Vespa_scooter_-_0332.jpg), Jorge Royan, CC BY-SA 3.0.
- Cafe racer — [Motorcycle 4.jpg](https://commons.wikimedia.org/wiki/File:Motorcycle_4.jpg), Aforakhilesh, CC0 1.0.
- Motocross — [Motocross.JPG](https://commons.wikimedia.org/wiki/File:Motocross.JPG), 28 *coloret* 28, CC BY-SA 2.5.
- Motor listrik — [Elektromotorrad von Zero Motorcycles](https://commons.wikimedia.org/wiki/File:Elektromotorrad_von_Zero_Motorcycles_mit_Z-Force-Batterie-Technologie.jpg), Zero Motorcycles, izin atribusi.

## Struktur singkat

- `app/src/main/java/com/garasikita/app/MainActivity.kt` — data katalog, pencarian, dan navigasi antarlayar.
- `app/src/main/res/layout/` — layout XML untuk katalog, kartu daftar, dan detail.
- `app/src/main/res/drawable-nodpi/` — foto kendaraan lokal agar tampil offline.
- `app/src/main/res/drawable/` — ikon vektor dan latar kartu.
- `app/src/main/AndroidManifest.xml` — deklarasi aplikasi dan activity utama.
