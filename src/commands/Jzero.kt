package commands
import access.MemoryAccess
import operands.ValueOperand
import registerDataHolders.ProgramCounter

class Jzero(
    val address: ValueOperand,
    val programCounter: ProgramCounter,
    memory: ArrayList<Int>,): Command, MemoryAccess(memory) {

    override fun execute() {
        val memoryAccess = MemoryAccess(super.getMemory())
        try {
            if (readMemory(0u) == 0) {
                programCounter.counter = address.resolve(memoryAccess).toUInt() - 1u
            }
        } catch (e: NumberFormatException) {
            throw IllegalStateException("Jumped to an undefined instruction label!")
        }

    }
}