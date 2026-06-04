package operands

import access.MemoryAccess

interface AddressOperand: Operand {
    fun resolveToDirectAddress(memory: MemoryAccess): UInt
}