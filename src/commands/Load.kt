package commands
import access.MemoryAccess
import operands.AddressOperand


class Load(
    val address: AddressOperand,
    memory: ArrayList<Int>): Command, MemoryAccess(memory) {

    override fun execute() {
        val memoryAccess = MemoryAccess(super.getMemory())
        writeMemory(
            0u,
            readMemory(address.resolveToDirectAddress(memoryAccess))
        )
    }
}