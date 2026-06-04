package operands

import access.MemoryAccess

class IndirectAddress(val address: UInt): AddressOperand {

    override fun resolve(memory: MemoryAccess): Int {
        require(memory.readMemory(address) >= 0)
        {"Indirect resolve is not possible if the destination memory cell is smaller then zero: ${memory.readMemory(address)}"}
        return memory.readMemory(memory.readMemory(address).toUInt())
    }

    override fun resolveToDirectAddress(memory: MemoryAccess): UInt {
        require(memory.readMemory(address) >= 0)
        {"Indirect resolve is not possible if the destination memory cell is smaller then zero: ${memory.readMemory(address)}"}
        return memory.readMemory(address).toUInt()
    }
}