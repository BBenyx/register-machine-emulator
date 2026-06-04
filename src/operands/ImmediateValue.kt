package operands

import access.MemoryAccess

class ImmediateValue(val value: Int?): ValueOperand {

    override fun resolve(memory: MemoryAccess): Int {
        require(value != null) {"ERROR! Null value cannot be resolved!"}
        return this.value
    }
}