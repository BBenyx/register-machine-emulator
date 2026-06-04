package operands
import access.MemoryAccess

interface Operand {
    fun resolve(memory: MemoryAccess): Int
}