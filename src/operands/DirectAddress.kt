package operands

import access.MemoryAccess

class DirectAddress(val address: UInt): AddressOperand {

    override fun resolve(memory: MemoryAccess): Int {
        return memory.readMemory(address)
    }

    override fun resolveToDirectAddress(memory: MemoryAccess): UInt {
        return address
    }
}