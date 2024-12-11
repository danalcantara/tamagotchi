import kotlin.system.exitProcess

class Tamagotchi(private val name: String) {
    private var hunger = 50 // 0 (não está com fome) a 100 (muito fome)
    private var happiness = 50 // 0 (muito triste) a 100 (muito feliz)
    private var energy = 50 // 0 (exausto) a 100 (cheio de energia)

    fun status() {
        println("\n===== Status de $name =====")
        println("Fome: $hunger/100")
        println("Felicidade: $happiness/100")
        println("Energia: $energy/100")
        println("========================\n")
    }

    fun feed() {
        if (hunger <= 10) {
            println("$name não está com fome agora.")
        } else {
            hunger -= 10
            happiness += 5
            println("Você alimentou $name. Sua fome diminuiu e ele ficou mais feliz!")
        }
    }

    fun play() {
        if (energy <= 10) {
            println("$name está muito cansado para brincar agora.")
        } else {
            happiness += 10
            hunger += 10
            energy -= 15
            println("Você brincou com $name. Ele está mais feliz, mas também mais cansado e com fome.")
        }
    }

    fun sleep() {
        if (energy >= 90) {
            println("$name já está cheio de energia e não precisa dormir agora.")
        } else {
            energy += 30
            hunger += 10
            println("$name dormiu e recuperou energia, mas agora está com um pouco mais de fome.")
        }
    }

    fun passTime() {
        hunger += 5
        happiness -= 5
        energy -= 5

        if (hunger >= 100 || happiness <= 0 || energy <= 0) {
            println("Infelizmente, $name não conseguiu sobreviver. :(")
            exitProcess(0)
        }
    }
}

fun main(){
    println("Bem-vindo ao Tamagotchi!")
    print("Dê um nome para o seu Tamagotchi: ")
    val name = readln()
    val tamagotchi = Tamagotchi(name)

    while (true) {
        tamagotchi.status()
        println("O que você gostaria de fazer?\n1. Alimentar\n2. Brincar\n3. Colocar para dormir\n4. Sair")
        print("Escolha: ")

        when (readln().toIntOrNull()) {
            1 -> tamagotchi.feed()
            2 -> tamagotchi.play()
            3 -> tamagotchi.sleep()
            4 -> {
                println("Obrigado por jogar com $name! Até a próxima.")
                exitProcess(0)
            }
            else -> println("Escolha inválida. Tente novamente.")
        }

        tamagotchi.passTime()
    }
}
