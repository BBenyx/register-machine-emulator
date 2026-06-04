package access

open class MemoryAccess(private val memory: ArrayList<Int>) {

    fun readMemory(index: UInt): Int {
        if (index.toInt() > memory.size-1) {
            expandMemoryBy(index - (memory.size-1).toUInt())
        }
        return memory[index.toInt()]
    }

    fun writeMemory(index: UInt, value: Int) {
        if (index.toInt() > memory.size-1) {
            expandMemoryBy(index - (memory.size-1).toUInt())
        }

        memory[index.toInt()] = value
    }

    fun getMemory() = memory

    private fun expandMemoryBy(value: UInt) {
        for (i in 0u..value) {
            memory.add(0)
        }
    }
}