package commands
import access.MemoryAccess
import operands.AddressOperand
import registerDataHolders.InputTape


class Read(
    val address: AddressOperand,
    val inputTape: InputTape,
    memory: ArrayList<Int>,): Command, MemoryAccess(memory) {

    override fun execute() {
        require(inputTape.position.toInt() < inputTape.tape.size) {"ERROR! Input tape is out of bonds!"}
        val memoryAccess = MemoryAccess(super.getMemory())
        writeMemory(
            address.resolveToDirectAddress(memoryAccess),
            inputTape.tape[inputTape.position.toInt()])
        inputTape.position += 1u
    }
}