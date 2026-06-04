package commands
import access.MemoryAccess
import operands.AddressOperand


class Store(
    val address: AddressOperand,
    memory: ArrayList<Int>): Command, MemoryAccess(memory) {

    override fun execute() {
        val memoryAccess = MemoryAccess(super.getMemory())

        writeMemory(
            address.resolveToDirectAddress(memoryAccess),
            readMemory(0u))
    }
}