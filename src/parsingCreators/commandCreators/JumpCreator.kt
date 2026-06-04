package parsingCreators.commandCreators
import commands.Command
import commands.Jump
import operands.Operand
import operands.ValueOperand
import parsingCreators.CommandCreator
import registerDataHolders.ProgramCounter

class JumpCreator(val memory: ArrayList<Int>, val programCounter: ProgramCounter): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "JUMP"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Jump command cannot be created with a null address: $address"}
        require(address is ValueOperand) {"ERROR! Jump command cannot be created with non-immediate address: $address"}

        return Jump(address, programCounter, memory)
    }
}