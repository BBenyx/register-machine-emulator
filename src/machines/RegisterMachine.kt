package machines
import commands.Command
import registerDataHolders.InputTape
import registerDataHolders.ProgramCounter


class RegisterMachine(
    val program: List<Command>,
    val programCounter: ProgramCounter,
    val memory: ArrayList<Int>,
    val inputTape: InputTape,): Machine {

    override fun run() {
        while (programCounter.counter != null) {
            if (programCounter.counter!!.toInt() > program.size-1) break

            program[programCounter.counter!!.toInt()].execute()

            if (programCounter.counter != null) {
                programCounter.counter = programCounter.counter!! + 1u
            }
        }
        println()
    }

}