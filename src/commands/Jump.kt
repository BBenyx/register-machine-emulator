package commands
import access.MemoryAccess
import operands.ValueOperand
import registerDataHolders.ProgramCounter

class Jump(
    val address: ValueOperand,
    val programCounter: ProgramCounter,
    memory: ArrayList<Int>,): Command, MemoryAccess(memory) {

    override fun execute() {
        val memoryAccess = MemoryAccess(super.getMemory())
        try {
            programCounter.counter = address.resolve(memoryAccess).toUInt() - 1u
        } catch (e: NumberFormatException) {
            throw IllegalStateException("Jumped to an undefined instruction label!")
        }

    }
}