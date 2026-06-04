package commands
import operands.Operand
import access.MemoryAccess


class Mult(
    val address: Operand,
    memory: ArrayList<Int>): Command, MemoryAccess(memory) {

    override fun execute() {
        val memoryAccess = MemoryAccess(super.getMemory())
        writeMemory(
            0u,
            readMemory(0u) * address.resolve(memoryAccess))
    }
}