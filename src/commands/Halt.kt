package commands
import registerDataHolders.ProgramCounter

class Halt(val programCounter: ProgramCounter): Command {

    override fun execute() {
        programCounter.counter = null
    }
}