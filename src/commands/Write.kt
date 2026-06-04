package commands
import access.MemoryAccess
import operands.Operand


class Write(
    val address: Operand,
    memory: ArrayList<Int>): Command, MemoryAccess(memory) {

    override fun execute() {
        val memoryAccess = MemoryAccess(super.getMemory())
        print(address.resolve(memoryAccess))
    }
}