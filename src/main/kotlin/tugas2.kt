
fun main() {
    val menu = listOf(
        MenuItem("Ayam Bakar", 50000.0),
        MenuItem("Ayam Goreng", 40000.0),
        MenuItem("Ayam Geprek", 40000.0),
        MenuItem("Kulit Ayam Crispy", 15000.0),
        MenuItem("Sate Usus Ayam", 5000.0)
    )
    fun welcomeMessage() {
        println("Selamat Datang di warung BINAR!")
    }

    looping@ while (loop) {
        println("\nPilih Menu Makanan:")
        for ((index, item) in menu.withIndex()) {
            println("${index + 1}. ${item.name} - Rp ${item.price}")
        }

        print("\nSilahkan pilih menu makanan (0 untuk keluar): ")
        val choice = readLine()?.toIntOrNull() ?: continue

        if (choice == 0) {
            println("Terima kasih, anda berhasil memesan makanan!")
            break
        } else if (choice >= 1 && choice <= menu.size) {
            val selectedMenuItem = menu[choice - 1]
            println("Anda memesan ${selectedMenuItem.name} - Rp ${selectedMenuItem.price}")

            print("Masukkan pembayaran: ")
            val inputUser: Double = readLine()?.toDoubleOrNull() ?: continue
            val payment = checkPembayaran(inputUser, selectedMenuItem.price)
            if (!payment) {
                println("-----Maaf Pembayaran Gagal!!-----")
                continue@looping
            }
            println("-----Pembayaran Berhasil!!-----")

            println("Masukkan Pilihan Metode Pengiriman")
            val deliveries: String = """
                1. Take Away
                2. Delivery
            """.trimIndent()
            println(deliveries)

            println("Pilihan Anda: ")
            val delivery: Int = readLine()?.toIntOrNull() ?: continue

            if (delivery == 1) {
                println("Makananmu sedang dimasak .....")
                Thread.sleep(5000) // Jeda 5 detik
                println("Makananmu sudah siap! Silahkan ambil di resto ya! .....")
                Thread.sleep(5000) // Jeda 5 detik
                println("Pesanan selesai! .....")
                return
            } else if (delivery == 2) {
                println("Makananmu sedang dimasak .....")
                Thread.sleep(5000) // Jeda 5 detik
                println("Makananmu sudah siap! Driver segera menuju tempatmu! .....")
                Thread.sleep(5000) // Jeda 5 detik
                println("Driver sampai! Pesanan selesai! .....")
                return
            }
        } else {
            println("Maaf, pembayaran Anda gagal.")
        }
    }
}

fun checkPembayaran(inputUser: Double, foodPrice: Double): Boolean {
    return inputUser >= foodPrice
}
data class MenuItem(val name: String, val price: Double)

var loop = true;