package parsingCreators.commandCreators
import commands.Command
import commands.Jzero
import operands.Operand
import operands.ValueOperand
import parsingCreators.CommandCreator
import registerDataHolders.ProgramCounter

class JzeroCreator(val memory: ArrayList<Int>, val programCounter: ProgramCounter): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "JZERO"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Jzero command cannot be created with a null address: $address"}
        require(address is ValueOperand) {"ERROR! Jzero command cannot be created with non-immediate address: $address"}

        return Jzero(address, programCounter, memory)
    }
}